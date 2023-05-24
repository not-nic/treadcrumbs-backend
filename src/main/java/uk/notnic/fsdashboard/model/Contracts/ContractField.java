package uk.notnic.fsdashboard.model.Contracts;

import uk.notnic.fsdashboard.BooleanAdapter;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "field")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class ContractField {

    @XmlAttribute(name = "id")
    private Integer fieldNum;

    @XmlAttribute(name = "growthState")
    private Integer growthStage;

    @XmlAttribute(name = "fruitTypeName")
    private String currentCropType;

    @XmlAttribute(name = "sprayFactor")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean fertilized;

    @XmlAttribute(name = "plowFactor")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean plowed;

    @XmlAttribute(name = "weedFactor")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean weeded;

    @XmlAttribute(name = "limeFactor")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean limed;

    @XmlAttribute(name = "stubbleFactor")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean mulched;

    public ContractField() {
    }

    public ContractField(Integer fieldNum, Integer growthStage, String currentCropType, Boolean fertilized,
                         Boolean plowed, Boolean weeded, Boolean limed, Boolean mulched) {
        this.fieldNum = fieldNum;
        this.growthStage = growthStage;
        this.currentCropType = currentCropType;
        this.fertilized = fertilized;
        this.plowed = plowed;
        this.weeded = weeded;
        this.limed = limed;
        this.mulched = mulched;
    }

    public Integer getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(Integer fieldNum) {
        this.fieldNum = fieldNum;
    }

    public Integer getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(Integer growthStage) {
        this.growthStage = growthStage;
    }

    public String getCurrentCropType() {
        return currentCropType;
    }

    public void setCurrentCropType(String currentCropType) {
        this.currentCropType = currentCropType;
    }

    public Boolean getFertilized() {
        return fertilized;
    }

    public void setFertilized(Boolean fertilized) {
        this.fertilized = fertilized;
    }

    public Boolean getPlowed() {
        return plowed;
    }

    public void setPlowed(Boolean plowed) {
        this.plowed = plowed;
    }

    public Boolean getWeeded() {
        return weeded;
    }

    public void setWeeded(Boolean weeded) {
        this.weeded = weeded;
    }

    public Boolean getLimed() {
        return limed;
    }

    public void setLimed(Boolean limed) {
        this.limed = limed;
    }

    public Boolean getMulched() {
        return mulched;
    }

    public void setMulched(Boolean mulched) {
        this.mulched = mulched;
    }
}
