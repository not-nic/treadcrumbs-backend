package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.service.FieldService;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FieldsController {

    private final FieldService fieldService;

    public FieldsController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/test-fields")
    public void setFields() throws JAXBException {
        fieldService.createEntityFromXMLs("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/farmland.xml",
                "C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/precisionFarming.xml");
    }

    @GetMapping("/fields")
    public List<Field> allFields() {
        return fieldService.getAllFields();
    }

    @GetMapping("/fields/{id}")
    public Optional<Field> findFieldById(@PathVariable long id) {
        return fieldService.getFieldById(id);
    }

    @GetMapping("/fields/owned")
    public List<Field> findFieldByOwned() {
        return fieldService.getOwnedFields();
    }

    @PostMapping("/fields/{id}")
    public Field updateField(@PathVariable long id, @RequestBody Field field) {
        return fieldService.updateField(id, field);
    }

    @GetMapping("/fields/delete/{id}")
    public String deleteById(@PathVariable long id) {
        fieldService.DeleteFieldById(id);
        return String.format("Field %s deleted", id);
    }

    @PostMapping("/fields")
    public void createField(@RequestBody Field field) {
        fieldService.createField(field);
    }
}
