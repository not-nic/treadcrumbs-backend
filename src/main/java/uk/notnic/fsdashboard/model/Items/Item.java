package uk.notnic.fsdashboard.model.Items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import uk.notnic.fsdashboard.model.Coordinate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@MappedSuperclass
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @XmlAttribute(name = "className")
    private String className;

    @XmlAttribute(name = "filename")
    private String filename;

    @JsonIgnore
    @XmlAttribute(name = "position")
    private String pos;

    private Coordinate position;

    @XmlAttribute(name = "fillLevel")
    private Double fillLevel;

    @XmlAttribute(name = "fillType")
    private String fillType;

    @XmlAttribute(name = "farmId")
    private Integer farmId;

    public Item() {
    }

    public Item(String className, String filename, String pos, Coordinate position, Double fillLevel, String fillType, Integer farmId) {
        this.className = className;
        this.filename = filename;
        this.pos = pos;
        this.position = position;
        this.fillLevel = fillLevel;
        this.fillType = fillType;
        this.farmId = farmId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Double getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(Double fillLevel) {
        this.fillLevel = fillLevel;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }
}
