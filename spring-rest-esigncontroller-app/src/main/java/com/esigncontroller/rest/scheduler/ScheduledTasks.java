package com.esigncontroller.rest.scheduler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.esigncontroller.rest.camel.responsebody.AgreementByIdResponse;
import com.esigncontroller.rest.camel.responsebody.Document;
import com.esigncontroller.rest.camel.responsebody.DocumentListResponse;
import com.esigncontroller.rest.db.entity.Inbound;
import com.esigncontroller.rest.db.entity.Outbound;
import com.esigncontroller.rest.db.repository.InboundRepository;
import com.esigncontroller.rest.db.repository.OutboundRepository;

@Component

/* * All the scheduled methods should follow the following two criteria - - The
 * method should have a void return type. - The method should not accept any
 * arguments.*/
 
public class ScheduledTasks {
	@Autowired
	private InboundRepository inboundRepository;
	
	@Autowired
	private OutboundRepository outboundRepository;

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private static final String IP_ADDRESS = "https://localhost:8443";

	/* <second> <minute> <hour> <day-of-month> <month> <day-of-week> */
	/* every hour 0 0 * ? * *       */
	/*to test every 10sec 0/10 * * * * **/
	@Scheduled(cron = "0 0 * ? * *")
	public void scheduleTaskWithCronExpression() throws KeyManagementException, NoSuchAlgorithmException {
		SSLUtil.turnOffSslChecking();
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		List<Outbound> outBoundList = outboundRepository.findAll();
		if (outBoundList == null || outBoundList.size() <= 0) {
			System.out.println("No data on query");
			return;
		}
		logger.info(outBoundList.toString());
		for (Outbound outBound : outBoundList) {
			
			// get agremeent id with status "OUT_FOR_SIGNATURE" as from outboundcontroller
			if (outBound.getOutboundStatus().equalsIgnoreCase("OUT_FOR_SIGNATURE")) {
				String agreementId = outBound.getAgreementId();
				System.out.println(agreementId);

				// get the agreement details based on id retrieved above
				RestTemplate restTemplate = new RestTemplate();
				String url = IP_ADDRESS + "/agreements/" + agreementId;
				AgreementByIdResponse response = restTemplate.getForObject(url, AgreementByIdResponse.class);
				String agreementStatus = response.getStatus();
				
					//get agreement from Adbobe with status SIGNED in Adobe
					if (agreementStatus.equalsIgnoreCase("SIGNED")) {
						System.out.println("Test Status: " + agreementStatus + "for agreementId: " + agreementId);
						
						// get all the documents ids for the agreement
						RestTemplate agreemetDocsRestTemplate = new RestTemplate();
						String documentListUrl = IP_ADDRESS + "/agreements/" + agreementId + "/documents";
						DocumentListResponse documentListResponse = agreemetDocsRestTemplate.getForObject(documentListUrl,
								DocumentListResponse.class);
						List<Document> documentList = documentListResponse.getDocuments();
						if (documentList == null || documentList.size() <= 0) {
							System.out.println("No list of documents retrieved for agreement: " + agreementId);
							return;
						}
							for (Document document : documentList) {
								//before download - store all the record of documentid,agreementId,inboundStatus[COMPLETED] retrieved into inbound db , 
								final String uploadFolder = "C:\\temp\\";
								String docId = document.getId();
								Inbound inboundRequest = new Inbound();
								inboundRequest.setAgreementId(agreementId);
								inboundRequest.setDocumentId(docId);
								inboundRequest.setInboundStatus("RETRIEVED");
								inboundRequest.setTargetDir(uploadFolder);
								inboundRepository.save(inboundRequest);
								// download the document
								RestTemplate downloadFileStreamRestTemplate = new RestTemplate();
								String downloadDocURL = IP_ADDRESS + "/agreements/" + agreementId + "/documents/"
										+ docId;
								byte[] docFileStreamResponse = downloadFileStreamRestTemplate.getForObject(downloadDocURL,
										byte[].class);
								writeBytesToFileStream(uploadFolder,docFileStreamResponse,docId);
								//mark the inbound table:inboundStatus as "ready_for_upload"
								inboundRequest.setInboundStatus("READY_FOR_UPLOAD");
								inboundRepository.save(inboundRequest);
							}
	
					}

			}
			//after download mark the outboundStatus as completed for this agreement in outbound  table
			outBound.setOutboundStatus("COMPLETED");
			outboundRepository.save(outBound);
		}

	}
	
	public void writeBytesToFileStream(String UploadFolder,byte[] bFile,String fileName) {
		//final String UPLOAD_FOLDER = "C:\\temp\\";
		FileInputStream fileInputStream = null;
		try {
            //save bytes[] into a file
            writeBytesToFile(bFile, UploadFolder + fileName + ".pdf");

            System.out.println("Done");

        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
	}
	
    private static void writeBytesToFile(byte[] bFile, String fileDest) {

        try (FileOutputStream fileOuputStream = new FileOutputStream(fileDest)) {
            fileOuputStream.write(bFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
