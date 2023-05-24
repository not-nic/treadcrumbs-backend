package uk.notnic.fsdashboard.model.Contracts.ContractTypes;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sow")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Sowing implements ContractType {

    @XmlAttribute(name = "fruitTypeName")
    private String fruitType;

    @Override
    public Double calculatePercentageComplete(Double expected, Double deposited) {
        return null;
    }

    public Sowing() {
    }

    public Sowing(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }
}
