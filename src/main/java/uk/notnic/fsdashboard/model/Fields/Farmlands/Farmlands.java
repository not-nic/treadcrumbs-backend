package uk.notnic.fsdashboard.model.Fields.Farmlands;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "farmlands")
@XmlAccessorType(XmlAccessType.FIELD)
public class Farmlands {

    @XmlElement(name = "farmland")
    List<PlayerFarmland> playerFarmlands;

    public Farmlands() {
    }

    public Farmlands(List<PlayerFarmland> playerFarmlands) {
        this.playerFarmlands = playerFarmlands;
    }

    public List<PlayerFarmland> getPlayerFarmlands() {
        return playerFarmlands;
    }

    public void setPlayerFarmlands(List<PlayerFarmland> playerFarmlands) {
        this.playerFarmlands = playerFarmlands;
    }
}
