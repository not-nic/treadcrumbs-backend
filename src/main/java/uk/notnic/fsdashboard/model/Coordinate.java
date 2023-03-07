package uk.notnic.fsdashboard.model;

public class Coordinate {
    private Double x;
    private Double y;
    private Double z;

    public Coordinate() {

    }

    public Coordinate(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    public String toString() {
        return String.format("X: %s, Y: %s, Z: %s", this.x, this.y, this.z);
    }

    public Coordinate createCoordinate(String position) {
        String[] coordArray = position.split(" ");

        double x = Double.parseDouble(coordArray[0]);
        double y = Double.parseDouble(coordArray[1]);
        double z = Double.parseDouble(coordArray[2]);

        return new Coordinate(x, y, z);
    }
}
