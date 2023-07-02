package uk.notnic.fsdashboard.model.Placeables.Animals.HusbandryAnimals;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "clusters")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Cluster implements Serializable {

    @XmlElement(name = "animal")
    private ArrayList<Animal> animals;

    public Cluster() {
    }

    public Cluster(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
