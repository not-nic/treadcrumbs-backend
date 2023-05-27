package uk.notnic.fsdashboard.model.Fields;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "farmlandStatistic")
@XmlAccessorType(XmlAccessType.FIELD)
public class FarmlandStatistic {

    @XmlAttribute(name = "farmlandId")
    private Integer farmlandId;

    @XmlElement(name = "totalCounter")
    private TotalCounter totalCounter;

    public FarmlandStatistic() {
    }

    public FarmlandStatistic(Integer farmlandId, TotalCounter totalCounter) {
        this.farmlandId = farmlandId;
        this.totalCounter = totalCounter;
    }

    public Integer getFarmlandId() {
        return farmlandId;
    }

    public void setFarmlandId(Integer farmlandId) {
        this.farmlandId = farmlandId;
    }

    public TotalCounter getTotalCounter() {
        return totalCounter;
    }

    public void setTotalCounter(TotalCounter totalCounter) {
        this.totalCounter = totalCounter;
    }
}
