package uk.notnic.fsdashboard.model.Contracts.ContractTypes;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "harvest")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Harvesting implements ContractType {

    @XmlAttribute(name = "expectedLiters")
    private Double expectedLitres;

    @XmlAttribute(name = "depositedLiters")
    private Double depositedLitres;

    @XmlAttribute(name = "sellPointPlaceableId")
    private Integer harvestDeliveryPoint;

    private Double percentageComplete;

    @Override
    public Double calculatePercentageComplete(Double expected, Double deposited) {
        return percentageComplete = (double) Math.round(( deposited / expected ) * 100);
    }

    public Harvesting() {
    }

    public Harvesting(Double expectedLitres, Double depositedLitres, Integer harvestDeliveryPoint, Double percentageComplete) {
        this.expectedLitres = expectedLitres;
        this.depositedLitres = depositedLitres;
        this.harvestDeliveryPoint = harvestDeliveryPoint;
        this.percentageComplete = percentageComplete;
    }

    public Double getExpectedLitres() {
        return expectedLitres;
    }

    public void setExpectedLitres(Double expectedLitres) {
        this.expectedLitres = expectedLitres;
    }

    public Double getDepositedLitres() {
        return depositedLitres;
    }

    public void setDepositedLitres(Double depositedLitres) {
        this.depositedLitres = depositedLitres;
    }

    public Integer getHarvestDeliveryPoint() {
        return harvestDeliveryPoint;
    }

    public void setHarvestDeliveryPoint(Integer harvestDeliveryPoint) {
        this.harvestDeliveryPoint = harvestDeliveryPoint;
    }

    public Double getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(Double percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
}
