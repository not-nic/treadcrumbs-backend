package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Farm.Farm;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.service.FarmService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmController {
    private final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/test-farms")
    public void setFields() throws JAXBException {
        farmService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\savegame18/farms.xml");
    }

    @GetMapping("/farm")
    public List<Farm> allFarms() {
        return farmService.getAllFarms();
    }

}
