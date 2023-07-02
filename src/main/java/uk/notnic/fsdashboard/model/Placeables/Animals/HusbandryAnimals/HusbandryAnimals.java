package uk.notnic.fsdashboard.model.Placeables.Animals.HusbandryAnimals;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "husbandryAnimals")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class HusbandryAnimals {

    @XmlElement(name = "clusters")
    private Cluster cluster;

    public HusbandryAnimals() {
    }

    public HusbandryAnimals(Cluster cluster) {
        this.cluster = cluster;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
}
