package uk.notnic.fsdashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "stats")
@SequenceGenerator(name = "stat_seq", allocationSize = 1)
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stat_seq")
    private Long id;
    private Double totalFuelUsage;
    private Double totalSeedUsage;
    private Double totalSprayUsage;
    private Double totalWorkedHectares;
    private Double totalWorkTime;
    private Double totalPlayTime;
    private Double totalDistanceDriven;

    public Statistics() {
    }

    public Statistics(Long id, Double totalFuelUsage, Double totalSeedUsage, Double totalSprayUsage,
                      Double totalWorkedHectares, Double totalWorkTime, Double totalPlayTime, Double totalDistanceDriven) {
        this.id = id;
        this.totalFuelUsage = totalFuelUsage;
        this.totalSeedUsage = totalSeedUsage;
        this.totalSprayUsage = totalSprayUsage;
        this.totalWorkedHectares = totalWorkedHectares;
        this.totalWorkTime = totalWorkTime;
        this.totalPlayTime = totalPlayTime;
        this.totalDistanceDriven = totalDistanceDriven;
    }

    public Long getId() {
        return id;
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

    public Double getTotalWorkTime() {
        return totalWorkTime;
    }

    public Double getTotalPlayTime() {
        return totalPlayTime;
    }

    public Double getTotalDistanceDriven() {
        return totalDistanceDriven;
    }
}
