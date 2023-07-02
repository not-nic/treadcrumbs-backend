package uk.notnic.fsdashboard.model.Placeables.Productions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductionStorageNode implements Serializable {
    @XmlAttribute(name = "fillType")
    String fillType;

    @XmlAttribute(name = "fillLevel")
    Double fillLevel;

    public ProductionStorageNode() {
    }

    public ProductionStorageNode(String fillType, Double fillLevel) {
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
