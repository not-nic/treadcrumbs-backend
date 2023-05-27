package uk.notnic.fsdashboard.model.Fields;

import uk.notnic.fsdashboard.model.Fields.EnvironmentalScores.EnvironmentalScore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "precisionFarming")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrecisionFarming {

    @XmlElement(name = "farmlandStatistics")
    private FarmlandStatistics farmlandStatistics;

    @XmlElement(name = "environmentalScore")
    private EnvironmentalScore environmentalScore;

    public PrecisionFarming() {
    }

    public PrecisionFarming(FarmlandStatistics farmlandStatistics, EnvironmentalScore environmentalScore) {
        this.farmlandStatistics = farmlandStatistics;
        this.environmentalScore = environmentalScore;
    }

    public FarmlandStatistics getFarmlandStatistics() {
        return farmlandStatistics;
    }

    public void setFarmlandStatistics(FarmlandStatistics farmlandStatistics) {
        this.farmlandStatistics = farmlandStatistics;
    }

    public EnvironmentalScore getEnvironmentalScore() {
        return environmentalScore;
    }

    public void setEnvironmentalScore(EnvironmentalScore environmentalScore) {
        this.environmentalScore = environmentalScore;
    }
}
