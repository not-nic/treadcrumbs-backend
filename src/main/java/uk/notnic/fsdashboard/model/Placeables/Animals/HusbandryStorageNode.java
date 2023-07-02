package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class HusbandryStorageNode {

    @XmlAttribute(name = "fillType")
    private String productFillType;

    @XmlAttribute(name = "fillLevel")
    private Double productFillLevel;

    public HusbandryStorageNode() {
    }

    public HusbandryStorageNode(String productFillType, Double productFillLevel) {
        this.productFillType = productFillType;
        this.productFillLevel = productFillLevel;
    }

    public String getProductFillType() {
        return productFillType;
    }

    public void setProductFillType(String productFillType) {
        this.productFillType = productFillType;
    }

    public Double getProductFillLevel() {
        return productFillLevel;
    }

    public void setProductFillLevel(Double productFillLevel) {
        this.productFillLevel = productFillLevel;
    }
}
