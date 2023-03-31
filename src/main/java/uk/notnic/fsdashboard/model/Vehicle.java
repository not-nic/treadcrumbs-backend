package uk.notnic.fsdashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@SequenceGenerator(name="vehicle_seq", allocationSize=1)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
    private Long id;
    private String name;
    private String licencePlate;
    private String aiLastJob;
    private String owned;
    @Embedded
    private Coordinate position;
    private Integer vehicleId;
    private Boolean drivable;
    @Embedded
    private Attachments attachment;
    private Double price;
    private Double age;
    private Double damage;
    private Double fuel;
    private Double operatingTime;

    public Vehicle() {

    }

    public Vehicle(Long id, String name, String licencePlate, String aiLastJob, String owned, Coordinate position, Integer vehicleId, Boolean drivable, Attachments attachment, Double price, Double age, Double damage, Double fuel, Double operatingTime) {
        this.id = id;
        this.name = name;
        this.licencePlate = licencePlate;
        this.aiLastJob = aiLastJob;
        this.position = position;
        this.vehicleId = vehicleId;
        this.drivable = drivable;
        this.owned = owned;
        this.attachment = attachment;
        this.price = price;
        this.age = age;
        this.damage = damage;
        this.fuel = fuel;
        this.operatingTime = operatingTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getAiLastJob() {
        return aiLastJob;
    }

    public String getOwned() {
        return owned;
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
}
