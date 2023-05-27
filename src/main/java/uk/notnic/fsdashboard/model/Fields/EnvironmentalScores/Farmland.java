package uk.notnic.fsdashboard.model.Fields.EnvironmentalScores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "farmland")
@XmlAccessorType(XmlAccessType.FIELD)
public class Farmland {

    @XmlAttribute(name = "farmlandId")
    private Long farmlandId;

    @XmlAttribute(name = "totalFieldArea")
    private Double fieldAreaHa;

    @XmlAttribute(name = "workedAreaNone")
    private Double workedAreaNone;

    @XmlAttribute(name = "workedAreaDeep")
    private Double workedAreaDeep;

    @XmlAttribute(name = "workedAreaFlat")
    private Double workedAreaFlat;

    @XmlAttribute(name = "workedAreaDirect")
    private Double workedAreaDirect;

    public Farmland() {
    }

    public Farmland(Long farmlandId, Double fieldAreaHa, Double workedAreaNone, Double workedAreaDeep, Double workedAreaFlat, Double workedAreaDirect) {
        this.farmlandId = farmlandId;
        this.fieldAreaHa = fieldAreaHa;
        this.workedAreaNone = workedAreaNone;
        this.workedAreaDeep = workedAreaDeep;
        this.workedAreaFlat = workedAreaFlat;
        this.workedAreaDirect = workedAreaDirect;
    }

    public Long getFarmlandId() {
        return farmlandId;
    }

    public void setFarmlandId(Long farmlandId) {
        this.farmlandId = farmlandId;
    }

    public Double getFieldAreaHa() {
        return fieldAreaHa;
    }

    public void setFieldAreaHa(Double fieldAreaHa) {
        this.fieldAreaHa = fieldAreaHa;
    }

    public Double getWorkedAreaNone() {
        return workedAreaNone;
    }

    public void setWorkedAreaNone(Double workedAreaNone) {
        this.workedAreaNone = workedAreaNone;
    }

    public Double getWorkedAreaDeep() {
        return workedAreaDeep;
    }

    public void setWorkedAreaDeep(Double workedAreaDeep) {
        this.workedAreaDeep = workedAreaDeep;
    }

    public Double getWorkedAreaFlat() {
        return workedAreaFlat;
    }

    public void setWorkedAreaFlat(Double workedAreaFlat) {
        this.workedAreaFlat = workedAreaFlat;
    }

    public Double getWorkedAreaDirect() {
        return workedAreaDirect;
    }

    public void setWorkedAreaDirect(Double workedAreaDirect) {
        this.workedAreaDirect = workedAreaDirect;
    }
}
