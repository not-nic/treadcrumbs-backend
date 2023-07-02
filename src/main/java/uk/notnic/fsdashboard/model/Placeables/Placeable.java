package uk.notnic.fsdashboard.model.Placeables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import uk.notnic.fsdashboard.XmlAdapters.FarmIdAdapter;
import uk.notnic.fsdashboard.model.Coordinate;
import uk.notnic.fsdashboard.model.Placeables.Animals.Husbandry;
import uk.notnic.fsdashboard.model.Placeables.Animals.HusbandryAnimals;
import uk.notnic.fsdashboard.model.Placeables.Animals.HusbandryFood;
import uk.notnic.fsdashboard.model.Placeables.Bunkers.BunkerSilo;
import uk.notnic.fsdashboard.model.Placeables.Productions.ProductionPoint;
import uk.notnic.fsdashboard.model.Placeables.SellPoints.SellingStation;
import uk.notnic.fsdashboard.model.Placeables.Silos.Silo;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "placeable")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "buildings")
@SequenceGenerator(name = "placeable_seq", allocationSize = 1)
public class Placeable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "placeable_seq")
    private Long Id;

    @XmlAttribute(name = "filename")
    private String name;

    @JsonIgnore
    @XmlAttribute(name = "position")
    private String pos;

    private Coordinate position;

    @XmlAttribute(name = "price")
    private Double price;

    @XmlAttribute(name = "farmId")
    @XmlJavaTypeAdapter(FarmIdAdapter.class)
    private Boolean owned;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "sellingStation")
    @Embedded
    private SellingStation sellingStation;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "productionPoint")
    @Embedded
    private ProductionPoint productionPoint;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "bunkerSilo")
    @Embedded
    private BunkerSilo bunkerSilo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "silo")
    @Embedded
    private Silo silo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "husbandry")
    @Embedded
    private Husbandry husbandry;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "husbandryAnimals")
    @Embedded
    private HusbandryAnimals husbandryAnimals;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "husbandryFood")
    @Embedded
    private HusbandryFood husbandryFood;

    public Placeable() {
    }

    public Placeable(Long id, String name, String pos, Coordinate position, Double price, Boolean owned,
                     SellingStation sellingStation, ProductionPoint productionPoint, BunkerSilo bunkerSilo,
                     Silo silo, Husbandry husbandry, HusbandryAnimals husbandryAnimals, HusbandryFood husbandryFood) {
        Id = id;
        this.name = name;
        this.pos = pos;
        this.position = position;
        this.price = price;
        this.owned = owned;
        this.sellingStation = sellingStation;
        this.productionPoint = productionPoint;
        this.bunkerSilo = bunkerSilo;
        this.silo = silo;
        this.husbandry = husbandry;
        this.husbandryAnimals = husbandryAnimals;
        this.husbandryFood = husbandryFood;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public SellingStation getSellingStation() {
        return sellingStation;
    }

    public void setSellingStation(SellingStation sellingStation) {
        this.sellingStation = sellingStation;
    }

    public ProductionPoint getProductionPoint() {
        return productionPoint;
    }

    public void setProductionPoint(ProductionPoint productionPoint) {
        this.productionPoint = productionPoint;
    }

    public BunkerSilo getBunkerSilo() {
        return bunkerSilo;
    }

    public void setBunkerSilo(BunkerSilo bunkerSilo) {
        this.bunkerSilo = bunkerSilo;
    }

    public Silo getSilo() {
        return silo;
    }

    public void setSilo(Silo silo) {
        this.silo = silo;
    }

    public Husbandry getHusbandry() {
        return husbandry;
    }

    public void setHusbandry(Husbandry husbandry) {
        this.husbandry = husbandry;
    }

    public HusbandryAnimals getHusbandryAnimals() {
        return husbandryAnimals;
    }

    public void setHusbandryAnimals(HusbandryAnimals husbandryAnimals) {
        this.husbandryAnimals = husbandryAnimals;
    }

    public HusbandryFood getHusbandryFood() {
        return husbandryFood;
    }

    public void setHusbandryFood(HusbandryFood husbandryFood) {
        this.husbandryFood = husbandryFood;
    }
}
