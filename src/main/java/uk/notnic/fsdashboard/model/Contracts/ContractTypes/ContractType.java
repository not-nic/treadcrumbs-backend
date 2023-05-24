package uk.notnic.fsdashboard.model.Contracts.ContractTypes;

public interface ContractType {

    Double calculatePercentageComplete(Double expected, Double deposited);
}
