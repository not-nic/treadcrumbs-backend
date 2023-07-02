package uk.notnic.fsdashboard.model.Placeables.Productions;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "productionPoint")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class ProductionPoint {

    @XmlElement(name = "production")
    ArrayList<Production> activeProductions;

    @XmlElement(name = "storage")
    ProductionStorage productionStorage;

    public ProductionPoint() {

    }

    public ProductionPoint(ArrayList<Production> activeProductions, ProductionStorage productionStorage) {
        this.activeProductions = activeProductions;
        this.productionStorage = productionStorage;
    }

    public ArrayList<Production> getActiveProductions() {
        return activeProductions;
    }

    public void setActiveProductions(ArrayList<Production> activeProductions) {
        this.activeProductions = activeProductions;
    }

    public ProductionStorage getStorage() {
        return productionStorage;
    }

    public void setStorage(ProductionStorage productionStorage) {
        this.productionStorage = productionStorage;
    }
}
