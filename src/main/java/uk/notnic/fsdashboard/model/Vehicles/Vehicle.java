package uk.notnic.fsdashboard.model.Vehicles;

import uk.notnic.fsdashboard.model.Coordinate;

import javax.persistence.*;

@MappedSuperclass
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String propertyState;
    private Double age;
    private Double price;
    private Double operatingTime;
    private Double damage;
    private Integer farmId;
    @Embedded
    private Coordinate position;

    public Vehicle() {

    }

    public Vehicle(Long id, String name, String propertyState, Double age, Double price, Double operatingTime,
                   Double damage, Integer farmId, Coordinate position) {
        this.id = id;
        this.name = name;
        this.propertyState = propertyState;
        this.age = age;
        this.price = price;
        this.operatingTime = operatingTime;
        this.damage = damage;
        this.farmId = farmId;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPropertyState() {
        return propertyState;
    }

    public Double getAge() {
        return age;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOperatingTime() {
        return operatingTime;
    }

    public Double getDamage() {
        return damage;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPropertyState(String propertyState) {
        this.propertyState = propertyState;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOperatingTime(Double operatingTime) {
        this.operatingTime = operatingTime;
    }

    public void setDamage(Double damage) {
        this.damage = damage;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
