package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "husbandryAnimals")
@XmlAccessorType(XmlAccessType.FIELD)
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
