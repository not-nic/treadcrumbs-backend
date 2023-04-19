package uk.notnic.fsdashboard.model.Vehicles;

import uk.notnic.fsdashboard.model.Coordinate;

import javax.persistence.*;

@Entity
@Table(name = "tractors")
@SequenceGenerator(name = "tractor_seq", allocationSize = 1)
public class Tractor extends Vehicle {

    private String licencePlate;
    private String aiLastJob;
    private Double fuel;
    @Embedded
    private Attachments attachment;

    public Tractor() {
    }


    public Tractor(Long id, String name, String propertyState, Double age, Double price, Double operatingTime,
                   Double damage, Integer farmId, Coordinate position, String licencePlate, String aiLastJob,
                   Double fuel, Attachments attachment) {
        super(id, name, propertyState, age, price, operatingTime, damage, farmId, position);
        this.licencePlate = licencePlate;
        this.aiLastJob = aiLastJob;
        this.fuel = fuel;
        this.attachment = attachment;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getAiLastJob() {
        return aiLastJob;
    }

    public Double getFuel() {
        return fuel;
    }

    public Attachments getAttachment() {
        return attachment;
    }

}
