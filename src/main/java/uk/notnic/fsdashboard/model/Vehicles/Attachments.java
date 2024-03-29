package uk.notnic.fsdashboard.model.Vehicles;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class Attachments {

    @Transient
    @JsonIgnore
    private Integer rootVehicleId;
    private ArrayList<Integer> attachmentIds;

    public Attachments() {
    }

    public Attachments(Integer rootVehicleId, ArrayList<Integer> attachmentIds) {
        this.rootVehicleId = rootVehicleId;
        this.attachmentIds = attachmentIds;
    }

    public Integer getRootVehicleId() {
        return rootVehicleId;
    }

    public ArrayList<Integer> getAttachmentIds() {
        return attachmentIds;
    }

    @Override
    public String toString() {
        return String.format("Vehicle Id: %s has attachments %s connected.", rootVehicleId, attachmentIds);
    }

    public HashMap<Integer, ArrayList<Integer>> createAttachmentLink(Attachments attachment) {
        HashMap<Integer, ArrayList<Integer>> link = new HashMap<>() {{
            put(attachment.getRootVehicleId(), attachment.getAttachmentIds());
        }};

        return link;
    }
}
