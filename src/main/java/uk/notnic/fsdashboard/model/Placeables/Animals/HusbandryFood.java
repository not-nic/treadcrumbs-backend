package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "husbandryFood")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class HusbandryFood {

    @XmlElement(name = "fillLevel")
    ArrayList<HusbandryFoodStorageNode> food;

    public HusbandryFood() {
    }

    public HusbandryFood(ArrayList<HusbandryFoodStorageNode> food) {
        this.food = food;
    }

    public ArrayList<HusbandryFoodStorageNode> getFood() {
        return food;
    }

    public void setFood(ArrayList<HusbandryFoodStorageNode> food) {
        this.food = food;
    }
}
