package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Career;
import uk.notnic.fsdashboard.service.CareerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }


    @GetMapping("/career")
    public List<Career> getCareer() {
        return careerService.getCareer();
    }

    @PostMapping("/career")
    public void createCareer(@RequestBody Career career) {
        careerService.createCareer(career);
    }

    @PostMapping("/career/{id}")
    public Career updateCareer(@PathVariable long id, @RequestBody Career career) {
        return careerService.updateCareer(id, career);
    }

    @GetMapping("/career/{id}")
    public Optional<Career> getCareer(@PathVariable long id) {
        return careerService.findCareerById(id);
    }
}
