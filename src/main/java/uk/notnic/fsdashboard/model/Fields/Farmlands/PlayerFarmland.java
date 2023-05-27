package uk.notnic.fsdashboard.model.Fields.Farmlands;

import uk.notnic.fsdashboard.XmlAdapters.FarmIdAdapter;
import uk.notnic.fsdashboard.XmlAdapters.GroundStateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "farmland")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerFarmland {

    @XmlAttribute(name = "id")
    private Long id;

    @XmlAttribute(name = "farmId")
    @XmlJavaTypeAdapter(FarmIdAdapter.class)
    private Boolean owned;

    public PlayerFarmland() {
    }

    public PlayerFarmland(Long id, Boolean owned) {
        this.id = id;
        this.owned = owned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }
}
