package uk.notnic.fsdashboard.model.Farm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "farms")
@XmlAccessorType(XmlAccessType.FIELD)
public class Farms {

    @XmlElement(name = "farm")
    private Farm farm;

    public Farms() {
    }

    public Farms(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
