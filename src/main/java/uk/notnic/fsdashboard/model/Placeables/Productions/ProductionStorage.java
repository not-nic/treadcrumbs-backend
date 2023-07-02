package uk.notnic.fsdashboard.model.Placeables.Productions;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "storage")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class ProductionStorage {

    @XmlElement(name = "node")
    ArrayList<ProductionStorageNode> nodes;

    public ProductionStorage() {
    }

    public ProductionStorage(ArrayList<ProductionStorageNode> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<ProductionStorageNode> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<ProductionStorageNode> nodes) {
        this.nodes = nodes;
    }
}
