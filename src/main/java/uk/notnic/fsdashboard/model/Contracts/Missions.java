package uk.notnic.fsdashboard.model.Contracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "missions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Missions {

    @XmlElement(name = "mission")
    List<Mission> missions;

    public Missions() {
    }

    public Missions(List<Mission> missions) {
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
