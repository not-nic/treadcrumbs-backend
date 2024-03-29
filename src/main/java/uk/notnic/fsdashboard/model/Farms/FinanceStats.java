package uk.notnic.fsdashboard.model.Farms;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "finances")
@SequenceGenerator(name="fin_seq", allocationSize = 1)
public class FinanceStats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fin_seq")
    private Long id;

    @XmlElement(name = "newVehiclesCost")
    private Double newVehiclesCost;

    @XmlElement(name = "soldVehicles")
    private Double soldVehicles;

    @XmlElement(name = "newAnimalsCost")
    private Double newAnimalsCost;

    @XmlElement(name = "soldAnimals")
    private Double soldAnimals;

    @XmlElement(name = "constructionCost")
    private Double constructionCost;

    @XmlElement(name = "soldBuildings")
    private Double soldBuildings;

    @XmlElement(name = "fieldPurchase")
    private Double fieldPurchase;

    @XmlElement(name = "fieldSelling")
    private Double fieldSelling;

    @XmlElement(name = "vehicleRunningCost")
    private Double vehicleRunningCost;

    @XmlElement(name = "vehicleLeasingCost")
    private Double vehicleLeasingCost;

    @XmlElement(name = "propertyMaintenance")
    private Double propertyMaintenance;

    @XmlElement(name = "propertyIncome")
    private Double propertyIncome;

    @XmlElement(name = "productionCosts")
    private Double productionCosts;

    @XmlElement(name = "soldWood")
    private Double soldWood;

    @XmlElement(name = "soldBales")
    private Double soldBales;

    @XmlElement(name = "soldWool")
    private Double soldWool;

    @XmlElement(name = "soldMilk")
    private Double soldMilk;

    @XmlElement(name = "soldProducts")
    private Double soldProducts;

    @XmlElement(name = "purchaseFuel")
    private Double purchaseFuel;

    @XmlElement(name = "purchaseSeeds")
    private Double purchaseSeeds;

    @XmlElement(name = "purchaseFertilizer")
    private Double purchaseFertilizer;

    @XmlElement(name = "purchaseSaplings")
    private Double purchaseSaplings;

    @XmlElement(name = "purchaseWater")
    private Double purchaseWater;

    @XmlElement(name = "harvestIncome")
    private Double harvestIncome;

    @XmlElement(name = "incomeBga")
    private Double incomeBga;

    @XmlElement(name = "missionIncome")
    private Double missionIncome;

    @XmlElement(name = "wagePayment")
    private Double wagePayment;

    @XmlElement(name = "other")
    private Double other;

    @XmlElement(name = "loanInterest")
    private Double loanInterest;
    public FinanceStats() {
    }

    public FinanceStats(Long id, Double newVehiclesCost, Double soldVehicles, Double newAnimalsCost, Double soldAnimals,
                        Double constructionCost, Double soldBuildings, Double fieldPurchase, Double fieldSelling,
                        Double vehicleRunningCost, Double vehicleLeasingCost, Double propertyMaintenance,
                        Double propertyIncome, Double productionCosts, Double soldWood, Double soldBales, Double soldWool,
                        Double soldMilk, Double soldProducts, Double purchaseFuel, Double purchaseSeeds,
                        Double purchaseFertilizer, Double purchaseSaplings, Double purchaseWater, Double harvestIncome,
                        Double incomeBga, Double missionIncome, Double wagePayment, Double other, Double loanInterest) {
        this.id = id;
        this.newVehiclesCost = newVehiclesCost;
        this.soldVehicles = soldVehicles;
        this.newAnimalsCost = newAnimalsCost;
        this.soldAnimals = soldAnimals;
        this.constructionCost = constructionCost;
        this.soldBuildings = soldBuildings;
        this.fieldPurchase = fieldPurchase;
        this.fieldSelling = fieldSelling;
        this.vehicleRunningCost = vehicleRunningCost;
        this.vehicleLeasingCost = vehicleLeasingCost;
        this.propertyMaintenance = propertyMaintenance;
        this.propertyIncome = propertyIncome;
        this.productionCosts = productionCosts;
        this.soldWood = soldWood;
        this.soldBales = soldBales;
        this.soldWool = soldWool;
        this.soldMilk = soldMilk;
        this.soldProducts = soldProducts;
        this.purchaseFuel = purchaseFuel;
        this.purchaseSeeds = purchaseSeeds;
        this.purchaseFertilizer = purchaseFertilizer;
        this.purchaseSaplings = purchaseSaplings;
        this.purchaseWater = purchaseWater;
        this.harvestIncome = harvestIncome;
        this.incomeBga = incomeBga;
        this.missionIncome = missionIncome;
        this.wagePayment = wagePayment;
        this.other = other;
        this.loanInterest = loanInterest;
    }

    public Long getId() {
        return id;
    }

    public Double getNewVehiclesCost() {
        return newVehiclesCost;
    }

    public Double getSoldVehicles() {
        return soldVehicles;
    }

    public Double getNewAnimalsCost() {
        return newAnimalsCost;
    }

    public Double getSoldAnimals() {
        return soldAnimals;
    }

    public Double getConstructionCost() {
        return constructionCost;
    }

    public Double getSoldBuildings() {
        return soldBuildings;
    }

    public Double getFieldPurchase() {
        return fieldPurchase;
    }

    public Double getFieldSelling() {
        return fieldSelling;
    }

    public Double getVehicleRunningCost() {
        return vehicleRunningCost;
    }

    public Double getVehicleLeasingCost() {
        return vehicleLeasingCost;
    }

    public Double getPropertyMaintenance() {
        return propertyMaintenance;
    }

    public Double getPropertyIncome() {
        return propertyIncome;
    }

    public Double getProductionCosts() {
        return productionCosts;
    }

    public Double getSoldWood() {
        return soldWood;
    }

    public Double getSoldBales() {
        return soldBales;
    }

    public Double getSoldWool() {
        return soldWool;
    }

    public Double getSoldMilk() {
        return soldMilk;
    }

    public Double getSoldProducts() {
        return soldProducts;
    }

    public Double getPurchaseFuel() {
        return purchaseFuel;
    }

    public Double getPurchaseSeeds() {
        return purchaseSeeds;
    }

    public Double getPurchaseFertilizer() {
        return purchaseFertilizer;
    }

    public Double getPurchaseSaplings() {
        return purchaseSaplings;
    }

    public Double getPurchaseWater() {
        return purchaseWater;
    }

    public Double getHarvestIncome() {
        return harvestIncome;
    }

    public Double getIncomeBga() {
        return incomeBga;
    }

    public Double getMissionIncome() {
        return missionIncome;
    }

    public Double getWagePayment() {
        return wagePayment;
    }

    public Double getOther() {
        return other;
    }

    public Double getLoanInterest() {
        return loanInterest;
    }

    public void setNewVehiclesCost(Double newVehiclesCost) {
        this.newVehiclesCost = newVehiclesCost;
    }

    public void setSoldVehicles(Double soldVehicles) {
        this.soldVehicles = soldVehicles;
    }

    public void setNewAnimalsCost(Double newAnimalsCost) {
        this.newAnimalsCost = newAnimalsCost;
    }

    public void setSoldAnimals(Double soldAnimals) {
        this.soldAnimals = soldAnimals;
    }

    public void setConstructionCost(Double constructionCost) {
        this.constructionCost = constructionCost;
    }

    public void setSoldBuildings(Double soldBuildings) {
        this.soldBuildings = soldBuildings;
    }

    public void setFieldPurchase(Double fieldPurchase) {
        this.fieldPurchase = fieldPurchase;
    }

    public void setFieldSelling(Double fieldSelling) {
        this.fieldSelling = fieldSelling;
    }

    public void setVehicleRunningCost(Double vehicleRunningCost) {
        this.vehicleRunningCost = vehicleRunningCost;
    }

    public void setVehicleLeasingCost(Double vehicleLeasingCost) {
        this.vehicleLeasingCost = vehicleLeasingCost;
    }

    public void setPropertyMaintenance(Double propertyMaintenance) {
        this.propertyMaintenance = propertyMaintenance;
    }

    public void setPropertyIncome(Double propertyIncome) {
        this.propertyIncome = propertyIncome;
    }

    public void setProductionCosts(Double productionCosts) {
        this.productionCosts = productionCosts;
    }

    public void setSoldWood(Double soldWood) {
        this.soldWood = soldWood;
    }

    public void setSoldBales(Double soldBales) {
        this.soldBales = soldBales;
    }

    public void setSoldWool(Double soldWool) {
        this.soldWool = soldWool;
    }

    public void setSoldMilk(Double soldMilk) {
        this.soldMilk = soldMilk;
    }

    public void setSoldProducts(Double soldProducts) {
        this.soldProducts = soldProducts;
    }

    public void setPurchaseFuel(Double purchaseFuel) {
        this.purchaseFuel = purchaseFuel;
    }

    public void setPurchaseSeeds(Double purchaseSeeds) {
        this.purchaseSeeds = purchaseSeeds;
    }

    public void setPurchaseFertilizer(Double purchaseFertilizer) {
        this.purchaseFertilizer = purchaseFertilizer;
    }

    public void setPurchaseSaplings(Double purchaseSaplings) {
        this.purchaseSaplings = purchaseSaplings;
    }

    public void setPurchaseWater(Double purchaseWater) {
        this.purchaseWater = purchaseWater;
    }

    public void setHarvestIncome(Double harvestIncome) {
        this.harvestIncome = harvestIncome;
    }

    public void setIncomeBga(Double incomeBga) {
        this.incomeBga = incomeBga;
    }

    public void setMissionIncome(Double missionIncome) {
        this.missionIncome = missionIncome;
    }

    public void setWagePayment(Double wagePayment) {
        this.wagePayment = wagePayment;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public void setLoanInterest(Double loanInterest) {
        this.loanInterest = loanInterest;
    }
}
