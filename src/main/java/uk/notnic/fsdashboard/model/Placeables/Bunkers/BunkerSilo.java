package uk.notnic.fsdashboard.model.Placeables.Bunkers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bunkerSilo")
@XmlAccessorType(XmlAccessType.FIELD)
public class BunkerSilo {

    @XmlAttribute(name = "fillLevel")
    private Double fillLevel;

    @XmlAttribute(name = "compactedFillLevel")
    private Double compactedFillLevel;

    @XmlAttribute(name = "fermentingTime")
    private Double fermentingTime;

    public BunkerSilo() {
    }

    public BunkerSilo(Double fillLevel, Double compactedFillLevel, Double fermentingTime) {
        this.fillLevel = fillLevel;
        this.compactedFillLevel = compactedFillLevel;
        this.fermentingTime = fermentingTime;
    }

    public Double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public Double getCompactedFillLevel() {
        return compactedFillLevel;
    }

    public void setCompactedFillLevel(Double compactedFillLevel) {
        this.compactedFillLevel = compactedFillLevel;
    }

    public Double getFermentingTime() {
        return fermentingTime;
    }

    public void setFermentingTime(Double fermentingTime) {
        this.fermentingTime = fermentingTime;
    }
}
