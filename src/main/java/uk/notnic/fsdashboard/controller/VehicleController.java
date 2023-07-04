package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Vehicles.Implement;
import uk.notnic.fsdashboard.model.Vehicles.Tractor;
import uk.notnic.fsdashboard.model.Vehicles.Vehicle;
import uk.notnic.fsdashboard.service.VehicleService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/test-vehicles")
    public void testVehicles() throws DocumentException {
        vehicleService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/vehicles.xml");
    }

    @GetMapping("/implements")
    public List<Implement> allImplements() {
        return vehicleService.getAllImplements();
    }

    @GetMapping("tractors")
    public List<Tractor> allTractors() {
        return vehicleService.getAllTractors();
    }
}
