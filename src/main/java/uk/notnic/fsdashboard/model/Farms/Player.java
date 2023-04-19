package uk.notnic.fsdashboard.model.Farms;


import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Player {

    @XmlAttribute(name = "uniqueUserId")
    private String uniqueUserId;
    @XmlAttribute(name = "lastNickname")
    private String playerName;

    public Player() {
    }

    public Player(String uniqueUserId, String playerName) {
        this.uniqueUserId = uniqueUserId;
        this.playerName = playerName;
    }

    public String getUniqueUserId() {
        return uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
