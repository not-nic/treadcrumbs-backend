package uk.notnic.fsdashboard.model.Fields;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "fields")
@SequenceGenerator(name = "field_seq", allocationSize = 1)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_seq")
    private Long id;


    @XmlAttribute(name = "plannedFruit")
    private String plannedFruit;

    public Field() {
    }

    public Field(String plannedFruit) {
        this.plannedFruit = plannedFruit;
    }

    public Long getId() {
        return id;
    }


    public String getPlannedFruit() {
        return plannedFruit;
    }
}
