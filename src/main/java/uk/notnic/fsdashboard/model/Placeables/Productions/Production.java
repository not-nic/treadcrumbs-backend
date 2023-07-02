package uk.notnic.fsdashboard.model.Placeables.Productions;

import uk.notnic.fsdashboard.XmlAdapters.EnabledAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

@XmlRootElement(name = "production")
@XmlAccessorType(XmlAccessType.FIELD)
public class Production implements Serializable {

    @XmlAttribute(name = "id")
    private String item;

    @XmlAttribute(name = "isEnabled")
    @XmlJavaTypeAdapter(EnabledAdapter.class)
    private Boolean isEnabled;

    public Production() {
    }

    public Production(String item, Boolean isEnabled) {
        this.item = item;
        this.isEnabled = isEnabled;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
