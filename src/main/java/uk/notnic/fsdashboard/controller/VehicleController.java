package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/vehicles")
    public List<Vehicle> allVehicles() {
        return vehicleService.getAllVehicles();
    }
}
