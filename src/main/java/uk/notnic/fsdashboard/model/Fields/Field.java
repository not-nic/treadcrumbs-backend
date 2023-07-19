package uk.notnic.fsdashboard.model.Fields;

import javax.persistence.*;

@Entity
@Table(name = "fields")
@SequenceGenerator(name = "field_seq", allocationSize = 1)
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "field_seq")
    private Long id;

    private String previousCrop;
    private String currentCrop;
    private Long farmlandId;
    private Integer growthStage;
    private Double fieldSizeHa;
    private Double fertilized;
    private Double limed;
    private Boolean owned;
    private Boolean plowed;
    private Boolean mulched;
    private Boolean weeded;

    public Field() {
    }

    public Field(Long id, String previousCrop, String currentCrop, Long farmlandId, Integer growthStage, Double fieldSizeHa,
                 Double fertilized, Double limed, Boolean owned, Boolean plowed, Boolean mulched, Boolean weeded) {
        this.id = id;
        this.previousCrop = previousCrop;
        this.currentCrop = currentCrop;
        this.farmlandId = farmlandId;
        this.growthStage = growthStage;
        this.fieldSizeHa = fieldSizeHa;
        this.fertilized = fertilized;
        this.limed = limed;
        this.owned = owned;
        this.plowed = plowed;
        this.mulched = mulched;
        this.weeded = weeded;
    }

    public Long getId() {
        return id;
    }

    public String getPreviousCrop() {
        return previousCrop;
    }

    public void setPreviousCrop(String previousCrop) {
        this.previousCrop = previousCrop;
    }

    public String getCurrentCrop() {
        return currentCrop;
    }

    public void setCurrentCrop(String currentCrop) {
        this.currentCrop = currentCrop;
    }

    public Long getFarmlandId() {
        return farmlandId;
    }

    public void setFarmlandId(Long farmlandId) {
        this.farmlandId = farmlandId;
    }

    public Integer getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(Integer growthStage) {
        this.growthStage = growthStage;
    }

    public Double getFieldSizeHa() {
        return fieldSizeHa;
    }

    public void setFieldSizeHa(Double fieldSizeHa) {
        this.fieldSizeHa = fieldSizeHa;
    }

    public Double getFertilized() {
        return fertilized;
    }

    public void setFertilized(Double fertilized) {
        this.fertilized = fertilized;
    }

    public Double getLimed() {
        return limed;
    }

    public void setLimed(Double limed) {
        this.limed = limed;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public Boolean getPlowed() {
        return plowed;
    }

    public void setPlowed(Boolean plowed) {
        this.plowed = plowed;
    }

    public Boolean getMulched() {
        return mulched;
    }

    public void setMulched(Boolean mulched) {
        this.mulched = mulched;
    }

    public Boolean getWeeded() {
        return weeded;
    }

    public void setWeeded(Boolean weeded) {
        this.weeded = weeded;
    }
}
