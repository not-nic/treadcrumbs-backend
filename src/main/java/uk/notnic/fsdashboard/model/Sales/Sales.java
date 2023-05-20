package uk.notnic.fsdashboard.model.Sales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sales {

    @XmlElement(name = "item")
    private List<Item> item;

    public Sales() {
    }

    public Sales(List<Item> item) {
        this.item = item;
    }

    public List<Item> getItems() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
