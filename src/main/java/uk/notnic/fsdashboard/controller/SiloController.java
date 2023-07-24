package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Placeables.Silos.SiloStorageNode;
import uk.notnic.fsdashboard.service.SiloService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SiloController {

    private final SiloService siloService;

    public SiloController(SiloService siloService) {
        this.siloService = siloService;
    }

    @GetMapping("/silos")
    public List<SiloStorageNode> allSilos() {
        return siloService.getAllSilos();
    }

    @PostMapping("/silos")
    public SiloStorageNode createSilo(@RequestBody SiloStorageNode silo) {
        return siloService.createSilo(silo);
    }

    @DeleteMapping("/silos/{id}")
    public String deleteSiloById(@PathVariable long id) {
        siloService.DeleteSiloById(id);

        return String.format("Deleted Silo %s", id);
    }
}
