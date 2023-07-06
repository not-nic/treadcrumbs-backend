package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Vehicles.Implement;
import uk.notnic.fsdashboard.model.Vehicles.Tractor;
import uk.notnic.fsdashboard.model.Vehicles.Vehicle;
import uk.notnic.fsdashboard.service.VehicleService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/implements/{id}")
    public Optional<Implement> findImplementById(@PathVariable long id) {
        return vehicleService.getImplementById(id);
    }

    @PostMapping("/implements/{id}")
    public Implement updateImplement(@PathVariable long id, @RequestBody Implement implement) {
        return vehicleService.updateImplement(id, implement);
    }

    @GetMapping("/implements")
    public List<Implement> allImplements() {
        return vehicleService.getAllImplements();
    }

    @GetMapping("/tractors/{id}")
    public Optional<Tractor> findTractorById(@PathVariable long id) {
        return vehicleService.getTractorById(id);
    }

    @PostMapping("/tractors/{id}")
    public Tractor updateTractor(@PathVariable long id, @RequestBody Tractor tractor) {
        return vehicleService.updateTractor(id, tractor);
    }

    @PostMapping("/tractors")
    public void createTractor(@RequestBody Tractor tractor) {
        vehicleService.createTractor(tractor);
    }

    @GetMapping("/tractors")
    public List<Tractor> allTractors() {
        return vehicleService.getAllTractors();
    }
}
