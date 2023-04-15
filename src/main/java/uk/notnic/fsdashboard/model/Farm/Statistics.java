package uk.notnic.fsdashboard.model.Farm;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "statistics")
@SequenceGenerator(name="stat_seq", allocationSize=1)
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stat_seq")
    private long id;

    @XmlElement(name = "traveledDistance")
    private Double totalDistance;
    @XmlElement(name = "fuelUsage")
    private Double totalFuelUsage;
    @XmlElement(name = "seedUsage")
    private Double totalSeedUsage;
    @XmlElement(name = "sprayUsage")
    private Double totalSprayUsage;
    @XmlElement(name = "workedHectares")
    private Double totalWorkedHectares;
    @XmlElement(name = "workedTime")
    private Double totalWorkedTime;
    @XmlElement(name = "playTime")
    private Double totalPlaytime;

    public Statistics() {
    }

    public Statistics(Double totalDistance, Double totalFuelUsage, Double totalSeedUsage, Double totalSprayUsage,
                      Double totalWorkedHectares, Double totalWorkedTime, Double totalPlaytime) {
        this.totalDistance = totalDistance;
        this.totalFuelUsage = totalFuelUsage;
        this.totalSeedUsage = totalSeedUsage;
        this.totalSprayUsage = totalSprayUsage;
        this.totalWorkedHectares = totalWorkedHectares;
        this.totalWorkedTime = totalWorkedTime;
        this.totalPlaytime = totalPlaytime;
    }

    public long getId() {
        return id;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public Double getTotalFuelUsage() {
        return totalFuelUsage;
    }

    public Double getTotalSeedUsage() {
        return totalSeedUsage;
    }

    public Double getTotalSprayUsage() {
        return totalSprayUsage;
    }

    public Double getTotalWorkedHectares() {
        return totalWorkedHectares;
    }

    public Double getTotalWorkedTime() {
        return totalWorkedTime;
    }

    public Double getTotalPlaytime() {
        return totalPlaytime;
    }


}
