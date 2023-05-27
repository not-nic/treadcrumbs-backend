package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Contracts.Mission;
import uk.notnic.fsdashboard.service.ContractService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/test-contracts")
    public void testContracts() throws JAXBException {
        contractService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/missions.xml");
    }

    @GetMapping("/contracts")
    public List<Mission> getAllContracts() {
        return contractService.getAllContracts();
    }
}
