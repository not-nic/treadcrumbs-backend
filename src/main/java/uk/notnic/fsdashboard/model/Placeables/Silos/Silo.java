package uk.notnic.fsdashboard.model.Placeables.Silos;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "silo")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Silo {

    @XmlElement(name = "storage")
    private SiloStorage siloStorage;

    public Silo() {
    }

    public Silo(SiloStorage siloStorage) {
        this.siloStorage = siloStorage;
    }

    public SiloStorage getSiloStorage() {
        return siloStorage;
    }

    public void setSiloStorage(SiloStorage siloStorage) {
        this.siloStorage = siloStorage;
    }
}
