package uk.notnic.fsdashboard.model.Fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "farmlandStatistics")
@XmlAccessorType(XmlAccessType.FIELD)
public class FarmlandStatistics {

    @XmlElement(name = "farmlandStatistics")
    private List<FarmlandStatistic> farmlandStatistics;

    public FarmlandStatistics() {
    }

    public FarmlandStatistics(List<FarmlandStatistic> farmlandStatistics) {
        this.farmlandStatistics = farmlandStatistics;
    }

    public List<FarmlandStatistic> getFarmlandStatistics() {
        return farmlandStatistics;
    }

    public void setFarmlandStatistics(List<FarmlandStatistic> farmlandStatistics) {
        this.farmlandStatistics = farmlandStatistics;
    }
}
