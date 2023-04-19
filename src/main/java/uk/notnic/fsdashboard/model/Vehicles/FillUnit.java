package uk.notnic.fsdashboard.model.Vehicles;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.ArrayList;

@Embeddable
public class FillUnit {

    private ArrayList<Unit> unit;

    public FillUnit() {

    }

    public FillUnit(ArrayList<Unit> unit) {
        this.unit = unit;
    }

    public ArrayList<Unit> getUnits() {
        return unit;
    }

    public void setUnits(ArrayList<Unit> unit) {
        this.unit = unit;
    }

    public static class Unit implements Serializable {
        private String fillType;
        private Double fillLevel;

        public Unit(String fillType, Double fillLevel) {
            this.fillType = fillType;
            this.fillLevel = fillLevel;
        }

        public String getFillType() {
            return fillType;
        }

        public Double getFillLevel() {
            return fillLevel;
        }

        public void setFillType(String fillUnit) {
            this.fillType = fillUnit;
        }

        public void setFillLevel(Double fillLevel) {
            this.fillLevel = fillLevel;
        }
    }
}
