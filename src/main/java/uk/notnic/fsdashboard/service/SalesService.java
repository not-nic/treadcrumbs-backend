package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Sales.Sale;
import uk.notnic.fsdashboard.model.Sales.Sales;
import uk.notnic.fsdashboard.repository.SalesRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class SalesService extends ServiceHelper {
    private final SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);

        JAXBContext jaxbContext = JAXBContext.newInstance(Sales.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Sales sales = (Sales) jaxbUnmarshaller.unmarshal(file);

        for (Sale salesSale : sales.getItems()) {
            Sale newSale = new Sale(null, salesSale.getTimeLeft(), salesSale.getName(), salesSale.getAge(),
                    salesSale.getPrice(), salesSale.getDamage(), salesSale.getWear(), salesSale.getOperatingTime());
            salesRepository.save(newSale);
        }
    }
}
