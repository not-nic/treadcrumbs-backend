package uk.notnic.fsdashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.MyEntity;
import uk.notnic.fsdashboard.service.MyEntityService;

@RestController
@RequestMapping("/api")
public class MyEntityController {

    // initialise services
    private final MyEntityService myEntityService;

    @Autowired
    public MyEntityController(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    @GetMapping("/delete")
    public void deleteAll() {
        myEntityService.deleteAllEntities();
    }

    @PostMapping("/my-entity")
    public void createEntity(@RequestBody MyEntity myEntity) {
        myEntityService.createMyEntity(myEntity);
    }

}
