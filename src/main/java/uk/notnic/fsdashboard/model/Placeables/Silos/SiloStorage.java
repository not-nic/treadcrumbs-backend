package uk.notnic.fsdashboard.model.Placeables.Silos;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "storage")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class SiloStorage {

    @XmlElement(name = "node")
    ArrayList<SiloStorageNode> siloStorageNodes;

    public SiloStorage() {
    }

    public SiloStorage(ArrayList<SiloStorageNode> siloStorageNodes) {
        this.siloStorageNodes = siloStorageNodes;
    }

    public ArrayList<SiloStorageNode> getSiloStorageNodes() {
        return siloStorageNodes;
    }

    public void setSiloStorageNodes(ArrayList<SiloStorageNode> siloStorageNodes) {
        this.siloStorageNodes = siloStorageNodes;
    }
}
