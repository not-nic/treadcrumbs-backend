package uk.notnic.fsdashboard.model.Placeables.Silos;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "silo")
@SequenceGenerator(name = "silo_seq", allocationSize = 1)
public class SiloStorageNode implements Serializable {

    @Serial
    private static final long serialVersionUID = -5215762300279083856L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "silo_seq")
    private Long id;

    @XmlAttribute(name = "fillType")
    private String fillType;

    @XmlAttribute(name = "fillLevel")
    private Double fillLevel;

    public SiloStorageNode() {
    }

    public SiloStorageNode(Long id, String fillType, Double fillLevel) {
        this.id = id;
        this.fillType = fillType;
        this.fillLevel = fillLevel;
    }

    public Long getId() {
        return id;
    }

    public String getFillType() {
        return fillType;
    }

    public Double getFillLevel() {
        return fillLevel;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public void setFillLevel(Double fillLevel) {
        this.fillLevel = fillLevel;
    }
}
