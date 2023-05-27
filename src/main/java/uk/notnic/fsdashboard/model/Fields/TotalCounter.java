package uk.notnic.fsdashboard.model.Fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "totalCounter")
@XmlAccessorType(XmlAccessType.FIELD)
public class TotalCounter {

    @XmlAttribute(name = "numSoilSamples")
    private Long totalSoilSamples;

    @XmlAttribute(name = "soilSampleCosts")
    private Double soilSampleCosts;

    @XmlAttribute(name = "usedLime")
    private Double totalLimeUsage;

    @XmlAttribute(name = "usedMineralFertilizer")
    private Double totalFertilizerUsage;

    @XmlAttribute(name = "usedLiquidFertilizer")
    private Double totalLiquidFertilizerUsage;

    @XmlAttribute(name = "usedManure")
    private Double totalManure;

    @XmlAttribute(name = "usedLiquidManure")
    private Double totalLiquidManure;

    @XmlAttribute(name = "usedSeeds")
    private Double totalUsedSeeds;

    @XmlAttribute(name = "usedHerbicide")
    private Double totalUsedHerbicide;

    @XmlAttribute(name = "yield")
    private Double totalYield;

    @XmlAttribute(name = "usedFuel")
    private Double totalUsedFuel;

    @XmlAttribute(name = "vehicleCosts")
    private Double totalVehicleCosts;

    @XmlAttribute(name = "helperCosts")
    private Double totalWorkerCosts;

    public TotalCounter() {
    }

    public TotalCounter(Long totalSoilSamples, Double soilSampleCosts, Double totalLimeUsage, Double totalFertilizerUsage,
                        Double totalLiquidFertilizerUsage, Double totalManure, Double totalLiquidManure, Double totalUsedSeeds,
                        Double totalUsedHerbicide, Double totalYield, Double totalUsedFuel, Double totalVehicleCosts,
                        Double totalWorkerCosts) {
        this.totalSoilSamples = totalSoilSamples;
        this.soilSampleCosts = soilSampleCosts;
        this.totalLimeUsage = totalLimeUsage;
        this.totalFertilizerUsage = totalFertilizerUsage;
        this.totalLiquidFertilizerUsage = totalLiquidFertilizerUsage;
        this.totalManure = totalManure;
        this.totalLiquidManure = totalLiquidManure;
        this.totalUsedSeeds = totalUsedSeeds;
        this.totalUsedHerbicide = totalUsedHerbicide;
        this.totalYield = totalYield;
        this.totalUsedFuel = totalUsedFuel;
        this.totalVehicleCosts = totalVehicleCosts;
        this.totalWorkerCosts = totalWorkerCosts;
    }

    public Long getTotalSoilSamples() {
        return totalSoilSamples;
    }

    public void setTotalSoilSamples(Long totalSoilSamples) {
        this.totalSoilSamples = totalSoilSamples;
    }

    public Double getSoilSampleCosts() {
        return soilSampleCosts;
    }

    public void setSoilSampleCosts(Double soilSampleCosts) {
        this.soilSampleCosts = soilSampleCosts;
    }

    public Double getTotalLimeUsage() {
        return totalLimeUsage;
    }

    public void setTotalLimeUsage(Double totalLimeUsage) {
        this.totalLimeUsage = totalLimeUsage;
    }

    public Double getTotalFertilizerUsage() {
        return totalFertilizerUsage;
    }

    public void setTotalFertilizerUsage(Double totalFertilizerUsage) {
        this.totalFertilizerUsage = totalFertilizerUsage;
    }

    public Double getTotalLiquidFertilizerUsage() {
        return totalLiquidFertilizerUsage;
    }

    public void setTotalLiquidFertilizerUsage(Double totalLiquidFertilizerUsage) {
        this.totalLiquidFertilizerUsage = totalLiquidFertilizerUsage;
    }

    public Double getTotalManure() {
        return totalManure;
    }

    public void setTotalManure(Double totalManure) {
        this.totalManure = totalManure;
    }

    public Double getTotalLiquidManure() {
        return totalLiquidManure;
    }

    public void setTotalLiquidManure(Double totalLiquidManure) {
        this.totalLiquidManure = totalLiquidManure;
    }

    public Double getTotalUsedSeeds() {
        return totalUsedSeeds;
    }

    public void setTotalUsedSeeds(Double totalUsedSeeds) {
        this.totalUsedSeeds = totalUsedSeeds;
    }

    public Double getTotalUsedHerbicide() {
        return totalUsedHerbicide;
    }

    public void setTotalUsedHerbicide(Double totalUsedHerbicide) {
        this.totalUsedHerbicide = totalUsedHerbicide;
    }

    public Double getTotalYield() {
        return totalYield;
    }

    public void setTotalYield(Double totalYield) {
        this.totalYield = totalYield;
    }

    public Double getTotalUsedFuel() {
        return totalUsedFuel;
    }

    public void setTotalUsedFuel(Double totalUsedFuel) {
        this.totalUsedFuel = totalUsedFuel;
    }

    public Double getTotalVehicleCosts() {
        return totalVehicleCosts;
    }

    public void setTotalVehicleCosts(Double totalVehicleCosts) {
        this.totalVehicleCosts = totalVehicleCosts;
    }

    public Double getTotalWorkerCosts() {
        return totalWorkerCosts;
    }

    public void setTotalWorkerCosts(Double totalWorkerCosts) {
        this.totalWorkerCosts = totalWorkerCosts;
    }
}
