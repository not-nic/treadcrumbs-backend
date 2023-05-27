package uk.notnic.fsdashboard.model.Fields.EnvironmentalScores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tillage")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tillage {

    @XmlElement(name = "farmland")
    List<Farmland> farmlandList;

    public Tillage() {
    }

    public Tillage(List<Farmland> farmlandList) {
        this.farmlandList = farmlandList;
    }

    public List<Farmland> getFarmlandList() {
        return farmlandList;
    }

    public void setFarmlandList(List<Farmland> farmlandList) {
        this.farmlandList = farmlandList;
    }
}
