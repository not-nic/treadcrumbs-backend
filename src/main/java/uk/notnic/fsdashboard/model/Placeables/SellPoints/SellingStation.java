package uk.notnic.fsdashboard.model.Placeables.SellPoints;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sellingStation")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class SellingStation {

    @XmlElement(name = "stats")
    private ArrayList<Stats> stats;

    public SellingStation() {
    }

    public SellingStation(ArrayList<Stats> stats) {
        this.stats = stats;
    }

    public ArrayList<Stats> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Stats> stats) {
        this.stats = stats;
    }
}
