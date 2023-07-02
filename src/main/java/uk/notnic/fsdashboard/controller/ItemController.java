package uk.notnic.fsdashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Items.Bale;
import uk.notnic.fsdashboard.service.ItemService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/test-items")
    public void testItems() throws JAXBException {
        itemService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/items.xml");
    }

    @GetMapping("/bales")
    public List<Bale> getAllBales() {
        return itemService.getAllBales();
    }
}
