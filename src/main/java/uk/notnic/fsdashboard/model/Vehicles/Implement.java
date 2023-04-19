package uk.notnic.fsdashboard.model.Vehicles;

import uk.notnic.fsdashboard.model.Coordinate;

import javax.persistence.*;

@Entity
@Table(name = "implements")
@SequenceGenerator(name = "imp_seq", allocationSize = 1)
public class Implement extends Vehicle {

    private String selectedFruitType;
    @Embedded
    private FillUnit fillUnit;

    public Implement() {

    }

    public Implement(Long id, String name, String propertyState, Double age, Double price, Double operatingTime,
                     Double damage, Integer farmId, Coordinate position, String selectedFruitType, FillUnit fillUnit) {
        super(id, name, propertyState, age, price, operatingTime, damage, farmId, position);
        this.selectedFruitType = selectedFruitType;
        this.fillUnit = fillUnit;
    }

    public String getSelectedFruitType() {
        return selectedFruitType;
    }

    public FillUnit getFillUnits() {
        return fillUnit;
    }
}
