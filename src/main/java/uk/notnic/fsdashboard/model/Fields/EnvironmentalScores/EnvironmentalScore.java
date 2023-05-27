package uk.notnic.fsdashboard.model.Fields.EnvironmentalScores;

import uk.notnic.fsdashboard.model.Fields.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "environmentalScore")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvironmentalScore {

    @XmlElement(name = "tillage")
    private Tillage tillage;

    public EnvironmentalScore() {
    }

    public EnvironmentalScore(Tillage tillage) {
        this.tillage = tillage;
    }

    public Tillage getTillage() {
        return tillage;
    }

    public void setTillage(Tillage tillage) {
        this.tillage = tillage;
    }
}
