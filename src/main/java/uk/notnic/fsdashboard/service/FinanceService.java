package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;
import uk.notnic.fsdashboard.model.Farms.Finances;
import uk.notnic.fsdashboard.repository.FinanceRepository;

import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    @Autowired
    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public List<FinanceStats> getAllFinances() {
        return financeRepository.findAll();
    }
}
