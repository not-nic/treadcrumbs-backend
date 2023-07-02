package uk.notnic.fsdashboard.model.Placeables.Animals.HusbandryFood;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Embeddable
@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class HusbandryFoodStorageNode implements Serializable {

    @XmlAttribute(name = "fillType")
    private String foodFillType;

    @XmlAttribute(name = "fillLevel")
    private Double foodFillLevel;

    public HusbandryFoodStorageNode() {
    }

    public HusbandryFoodStorageNode(String foodFillType, Double foodFillLevel) {
        this.foodFillType = foodFillType;
        this.foodFillLevel = foodFillLevel;
    }

    public String getFoodFillType() {
        return foodFillType;
    }

    public void setFoodFillType(String foodFillType) {
        this.foodFillType = foodFillType;
    }

    public Double getFoodFillLevel() {
        return foodFillLevel;
    }

    public void setFoodFillLevel(Double foodFillLevel) {
        this.foodFillLevel = foodFillLevel;
    }
}
