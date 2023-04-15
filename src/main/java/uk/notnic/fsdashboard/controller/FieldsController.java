package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.service.FieldService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FieldsController {

    private final FieldService fieldService;

    public FieldsController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @GetMapping("/test-fields")
    public void setFields() throws JAXBException {
        fieldService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\savegame18/fields.xml");
    }

    @GetMapping("/fields")
    public List<Field> allFields() {
        return fieldService.getAllFields();
    }
}
