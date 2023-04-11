package uk.notnic.fsdashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "farm")
@SequenceGenerator(name = "farm_seq", allocationSize = 1)
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farm_seq")
    private Long id;
    private Integer farmId;
    private String farmName;
    private String userId;
    private String playerName;
    private Double loan;
    private Double money;

    public Farm() {
    }

    public Farm(Long id, Integer farmId, String farmName, String userId, String playerName, Double loan, Double money) {
        this.id = id;
        this.farmId = farmId;
        this.farmName = farmName;
        this.userId = userId;
        this.playerName = playerName;
        this.loan = loan;
        this.money = money;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Double getLoan() {
        return loan;
    }

    public Double getMoney() {
        return money;
    }

    public Long getId() {
        return id;
    }
}
