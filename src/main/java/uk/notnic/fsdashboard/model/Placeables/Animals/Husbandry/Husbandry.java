package uk.notnic.fsdashboard.model.Placeables.Animals.Husbandry;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "husbandry")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Husbandry {

    @XmlElement(name = "storage")
    private HusbandryStorage husbandryStorage;

    public Husbandry() {
    }

    public Husbandry(HusbandryStorage husbandryStorage) {
        this.husbandryStorage = husbandryStorage;
    }

    public HusbandryStorage getHusbandryStorage() {
        return husbandryStorage;
    }

    public void setHusbandryStorage(HusbandryStorage husbandryStorage) {
        this.husbandryStorage = husbandryStorage;
    }
}
