package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;
import uk.notnic.fsdashboard.service.FinanceService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinanceController {

    public final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping("/finances")
    public List<FinanceStats> getFinances() {
        return financeService.getAllFinances();
    }

    @PostMapping("/finances")
    public String createFinanceStat(@RequestBody FinanceStats financeStats) throws IllegalAccessException {
        financeService.createFinanceStat(financeStats);
        return String.format("Finance Stat %s created.", financeStats.getId());
    }
}
