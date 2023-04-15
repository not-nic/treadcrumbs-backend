package uk.notnic.fsdashboard.model.Farm;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "farm")
@SequenceGenerator(name = "farm_seq", allocationSize = 1)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farm_seq")
    private Long id;

    @XmlAttribute(name = "name")
    private String farmName;

    @XmlAttribute(name = "loan")
    private Double loan;

    @XmlAttribute(name = "money")
    private Double money;

    @XmlElement(name = "players")
    @Embedded
    private Players players;

    @XmlElement(name = "statistics")
    @Transient
    private Statistics statistics;

    @XmlElement(name = "finances")
    @Transient
    private Finances finances;

    public Farm() {
    }

    public Farm(String farmName, Double loan, Double money, Players players) {
        this.farmName = farmName;
        this.loan = loan;
        this.money = money;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }


    public Statistics getStatistics() {
        return statistics;
    }
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Finances getFinances() {
        return finances;
    }

    public void setFinances(Finances finances) {
        this.finances = finances;
    }
}
