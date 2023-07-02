package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "clusters")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Cluster {

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
