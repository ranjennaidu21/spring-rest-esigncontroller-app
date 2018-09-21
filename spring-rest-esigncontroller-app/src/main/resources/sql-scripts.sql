CREATE TABLE outbound(
    id INT IDENTITY (1, 1) NOT NULL,
    agreemendid VARCHAR(MAX),
    referenceno VARCHAR(MAX),
	accesstoken VARCHAR(MAX),
	outboundstatus VARCHAR(MAX),
);

CREATE TABLE inbound(
    id INT IDENTITY (1, 1) NOT NULL,
    agreementid VARCHAR(MAX),
    targetdir VARCHAR(MAX),
	inboundstatus VARCHAR(MAX),
	documentid VARCHAR(MAX),
);

INSERT INTO outbound (agreemendid, referenceno, accesstoken,outboundstatus) VALUES
('CBJCHBCAABAA1x42SqE_n8PF7p46Fudv3YqE7NnaKsXW','1','token1','OUT_FOR_SIGNATURE'),
('CBJCHBCAABAA8fyxJzvoc0O2Se3_xwLxlICIA2XSnMxo','2','token2','OUT_FOR_SIGNATURE'),
('CBJCHBCAABAAM59-oKFi4pTr36ugsPqJmpdN35QAi8oY','3','token3','OUT_FOR_SIGNATURE'),
('CBJCHBCAABAAvDgqfcehfuileR2nDsbdK5u4_89-tctx','4','token4','ARCHIVED'),
('CBJCHBCAABAAFu7runqkh6Ucwq_wc860KjkYuYpsnuZ1','5','token5','ARCHIVED'),
('CBJCHBCAABAAhVgj5fptlNyYy8r4x8Sz6DN-dN7BE7NR','6','token6','OUT_FOR_SIGNATURE'),
('CBJCHBCAABAASi9WSAtVrxHwutYTePMlhJKk9S4uUNAY','7','token7','OUT_FOR_SIGNATURE');

