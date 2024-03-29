package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.notnic.fsdashboard.model.Sales.Sale;
import uk.notnic.fsdashboard.service.SalesService;

import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/test-sales")
    public void setSales() throws JAXBException {
        salesService.createEntityFromXML("C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\project_savegame/sales.xml");
    }

    @GetMapping("/sales")
    public List<Sale> allSalesItems() {
        return salesService.getAllSales();
    }
}
