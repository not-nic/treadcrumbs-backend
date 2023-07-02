package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "husbandry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Husbandry {

    @XmlElement(name = "storage")
    private HusbandryStorageNode husbandryStorage;

    public Husbandry() {
    }

    public Husbandry(HusbandryStorageNode husbandryStorage) {
        this.husbandryStorage = husbandryStorage;
    }

    public HusbandryStorageNode getHusbandryStorage() {
        return husbandryStorage;
    }

    public void setHusbandryStorage(HusbandryStorageNode husbandryStorage) {
        this.husbandryStorage = husbandryStorage;
    }
}
