package uk.notnic.fsdashboard.model.Placeables.Silos;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class SiloStorageNode implements Serializable {

    @XmlAttribute(name = "fillType")
    private String fillType;

    @XmlAttribute(name = "fillLevel")
    private Double fillLevel;

    public SiloStorageNode() {
    }

    public SiloStorageNode(String fillType, Double fillLevel) {
        this.fillType = fillType;
        this.fillLevel = fillLevel;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public Double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Double fillLevel) {
        this.fillLevel = fillLevel;
    }
}
