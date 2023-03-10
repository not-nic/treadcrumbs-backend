package uk.notnic.fsdashboard.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Vehicles extends MyEntity {

    private String name;
    @Embedded
    private Coordinate position;
    private Integer vehicleId;
    private Boolean drivable;
    @Embedded
    private Attachments attachment;
    private String aiLastJob;
    private Double price;
    private Double age;
    private Double damage;
    private Double fuel;
    private Double operatingTime;
    private String licencePlate;

    public Vehicles() {

    }

    public Vehicles(Long id, String name, Coordinate position, Integer vehicleId, Boolean drivable, Attachments attachment, String aiLastJob, Double price, Double age, Double damage, Double fuel, Double operatingTime, String licencePlate) {
        super(id);
        this.name = name;
        this.position = position;
        this.vehicleId = vehicleId;
        this.drivable = drivable;
        this.attachment = attachment;
        this.aiLastJob = aiLastJob;
        this.price = price;
        this.age = age;
        this.damage = damage;
        this.fuel = fuel;
        this.operatingTime = operatingTime;
        this.licencePlate = licencePlate;
    }

    public String getName() {
        return name;
    }

    public Coordinate getPosition() {
        return position;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public Boolean getDrivable() {
        return drivable;
    }

    public Attachments getAttachment() {
        return attachment;
    }

    public String getAiLastJob() {
        return aiLastJob;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAge() {
        return age;
    }

    public Double getDamage() {
        return damage;
    }

    public Double getFuel() {
        return fuel;
    }

    public Double getOperatingTime() {
        return operatingTime;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
}
