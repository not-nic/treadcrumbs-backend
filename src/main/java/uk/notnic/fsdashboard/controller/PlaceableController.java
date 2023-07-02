package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Placeables.Placeable;
import uk.notnic.fsdashboard.service.PlaceableService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceableController {

    private final PlaceableService placeableService;

    public PlaceableController(PlaceableService placeableService) {
        this.placeableService = placeableService;
    }

    @GetMapping("/test-placeable")
    public void testPlaceable() throws JAXBException {
        placeableService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/placeables.xml");
    }

    @GetMapping("/placeables")
    public List<Placeable> allPlaceables() {
        return placeableService.getAllPlaceables();
    }
}
