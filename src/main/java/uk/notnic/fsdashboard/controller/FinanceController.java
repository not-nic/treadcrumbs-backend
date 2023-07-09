package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
