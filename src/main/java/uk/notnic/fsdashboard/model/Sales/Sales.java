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
    private List<Sale> sale;

    public Sales() {
    }

    public Sales(List<Sale> sale) {
        this.sale = sale;
    }

    public List<Sale> getItems() {
        return sale;
    }

    public void setItem(List<Sale> sale) {
        this.sale = sale;
    }
}
