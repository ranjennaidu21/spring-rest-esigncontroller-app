
package com.esigncontroller.rest.camel.payload.responsebody;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class ParticipantSetsInfo {

    private List<ParticipantSet> participantSets = null;

    public List<ParticipantSet> getParticipantSets() {
        return participantSets;
    }

    public void setParticipantSets(List<ParticipantSet> participantSets) {
        this.participantSets = participantSets;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("participantSets", participantSets).toString();
    }

}
