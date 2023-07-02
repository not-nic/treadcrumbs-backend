package uk.notnic.fsdashboard.model.Placeables;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "placeables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Placeables {

    @XmlElement(name = "placeable")
    private List<Placeable> placeables;

    public Placeables() {
    }

    public Placeables(List<Placeable> placeables) {
        this.placeables = placeables;
    }

    public List<Placeable> getPlaceables() {
        return placeables;
    }

    public void setPlaceables(List<Placeable> placeables) {
        this.placeables = placeables;
    }
}
