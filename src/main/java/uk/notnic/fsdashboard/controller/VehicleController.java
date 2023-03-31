package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Vehicle;
import uk.notnic.fsdashboard.service.VehicleService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add-vehicle")
    public void createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }


    @GetMapping("/vehicles")
    public List<Vehicle> allVehicles() {
        return vehicleService.getAllVehicles();
    }
}
