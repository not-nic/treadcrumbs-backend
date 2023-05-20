package uk.notnic.fsdashboard.model.Sales;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sales")
@SequenceGenerator(name = "sale_seq", allocationSize = 1)
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
    private Long id;

    @XmlAttribute(name = "timeLeft")
    private Integer timeLeft;
    @XmlAttribute(name = "xmlFilename")
    private String name;
    @XmlAttribute(name = "age")
    private Double age;
    @XmlAttribute(name = "price")
    private Double price;
    @XmlAttribute(name = "damage")
    private Double damage;
    @XmlAttribute(name = "wear")
    private Double wear;
    @XmlAttribute(name = "operatingTime")
    private Double operatingTime;

    public Item() {
    }

    public Item(Long id, Integer timeLeft, String name, Double age, Double price,
                Double damage, Double wear, Double operatingTime) {
        this.id = id;
        this.timeLeft = timeLeft;
        this.name = name;
        this.age = age;
        this.price = price;
        this.damage = damage;
        this.wear = wear;
        this.operatingTime = operatingTime;
    }

    public Long getId() {
        return id;
    }

    public Integer getTimeLeft() {
        return timeLeft;
    }

    public String getName() {
        return name;
    }

    public Double getAge() {
        return age;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDamage() {
        return damage;
    }

    public Double getWear() {
        return wear;
    }

    public Double getOperatingTime() {
        return operatingTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeLeft(Integer timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public void setWear(Double wear) {
        this.wear = wear;
    }

    public void setOperatingTime(Double operatingTime) {
        this.operatingTime = operatingTime;
    }
}
