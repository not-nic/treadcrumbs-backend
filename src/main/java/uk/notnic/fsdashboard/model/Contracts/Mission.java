package uk.notnic.fsdashboard.model.Contracts;

import com.fasterxml.jackson.annotation.JsonInclude;
import uk.notnic.fsdashboard.model.Contracts.ContractTypes.Bailing;
import uk.notnic.fsdashboard.model.Contracts.ContractTypes.Harvesting;
import uk.notnic.fsdashboard.model.Contracts.ContractTypes.Sowing;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "mission")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "contracts")
@SequenceGenerator(name = "contract_seq", allocationSize = 1)
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_seq")
    private Long id;

    @XmlAttribute(name = "type")
    private String type;

    @XmlAttribute(name = "reward")
    private Double reward;

    @XmlAttribute(name = "success")
    private Boolean completed;

    @Embedded
    private ContractField field;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "harvest")
    @Embedded
    private Harvesting harvest;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "sow")
    @Embedded
    private Sowing sowing;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "bale")
    @Embedded
    private Bailing bailing;

    public Mission() {
    }

    public Mission(Long id, String type, Double reward, Boolean completed, ContractField field, Harvesting harvest, Sowing sowing, Bailing bailing) {
        this.id = id;
        this.type = type;
        this.reward = reward;
        this.completed = completed;
        this.field = field;
        this.harvest = harvest;
        this.sowing = sowing;
        this.bailing = bailing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public ContractField getField() {
        return field;
    }

    public void setField(ContractField field) {
        this.field = field;
    }

    public Harvesting getHarvest() {
        return harvest;
    }

    public void setHarvest(Harvesting harvest) {
        this.harvest = harvest;
    }

    public Sowing getSowing() {
        return sowing;
    }

    public void setSowing(Sowing sowing) {
        this.sowing = sowing;
    }

    public Bailing getBailing() {
        return bailing;
    }

    public void setBailing(Bailing bailing) {
        this.bailing = bailing;
    }
}
