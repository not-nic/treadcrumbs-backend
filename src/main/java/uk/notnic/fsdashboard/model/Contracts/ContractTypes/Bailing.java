package uk.notnic.fsdashboard.model.Contracts.ContractTypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bale")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Bailing implements ContractType {

    @XmlAttribute(name = "depositedLiters")
    private Double depositedBales;

    @XmlAttribute(name = "fillTypeName")
    private String expectedBale;

    @XmlAttribute(name = "sellPointPlaceableId")
    private Integer baleDeliveryPoint;

    @Override
    public Double calculatePercentageComplete(Double expected, Double deposited) {
        return null;
    }

    public Bailing() {
    }

    public Bailing(Double depositedBales, String expectedBale, Integer baleDeliveryPoint) {
        this.depositedBales = depositedBales;
        this.expectedBale = expectedBale;
        this.baleDeliveryPoint = baleDeliveryPoint;
    }

    public Double getDepositedBales() {
        return depositedBales;
    }

    public void setDepositedBales(Double depositedBales) {
        this.depositedBales = depositedBales;
    }

    public String getExpectedBale() {
        return expectedBale;
    }

    public void setExpectedBale(String expectedBale) {
        this.expectedBale = expectedBale;
    }

    public Integer getBaleDeliveryPoint() {
        return baleDeliveryPoint;
    }

    public void setBaleDeliveryPoint(Integer baleDeliveryPoint) {
        this.baleDeliveryPoint = baleDeliveryPoint;
    }
}
