package uk.notnic.fsdashboard.model.Placeables.Animals.Husbandry;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "storage")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class HusbandryStorage {

    @XmlElement(name = "node")
    ArrayList<HusbandryStorageNode> husbandryStorageNodes;

    public HusbandryStorage() {
    }

    public HusbandryStorage(ArrayList<HusbandryStorageNode> husbandryStorageNodes) {
        this.husbandryStorageNodes = husbandryStorageNodes;
    }

    public ArrayList<HusbandryStorageNode> getHusbandryStorageNodes() {
        return husbandryStorageNodes;
    }

    public void setHusbandryStorageNodes(ArrayList<HusbandryStorageNode> husbandryStorageNodes) {
        this.husbandryStorageNodes = husbandryStorageNodes;
    }
}
