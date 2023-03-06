package uk.notnic.fsdashboard.model;

import javax.persistence.Entity;

@Entity
public class Vehicles extends MyEntity {

    private String brand;
    private String model;
    private Double age;
    private Double damage;
    private Double fuel;
    private Double operatingTime;
    private String numberPlate;

    public Vehicles() {

    }

    public Vehicles(Long id, String brand, String model, Double age, Double damage, Double fuel, Double operatingTime, String numberPlate) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.age = age;
        this.damage = damage;
        this.fuel = fuel;
        this.operatingTime = operatingTime;
        this.numberPlate = numberPlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
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

    public String getNumberPlate() {
        return numberPlate;
    }
}
