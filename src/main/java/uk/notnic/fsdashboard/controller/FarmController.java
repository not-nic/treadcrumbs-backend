package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Farm;
import uk.notnic.fsdashboard.repository.FarmRepository;
import uk.notnic.fsdashboard.service.FarmService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FarmController {

    private final FarmRepository farmRepository;

    public FarmController(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

}
