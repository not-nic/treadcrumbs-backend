package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Coordinate;
import uk.notnic.fsdashboard.model.Items.Bale;
import uk.notnic.fsdashboard.model.Items.Item;
import uk.notnic.fsdashboard.model.Items.Items;
import uk.notnic.fsdashboard.repository.BaleRepository;
import org.fusesource.jansi.Ansi;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class ItemService implements ServiceHelper {

    private final BaleRepository baleRepository;

    @Autowired
    public ItemService(BaleRepository baleRepository) {
        this.baleRepository = baleRepository;
    }

    public List<Bale> getAllBales() {
        return baleRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Items.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Items items = (Items) jaxbUnmarshaller.unmarshal(file);

        // total fill levels for all bale types
        double totalStrawFillLevel = 0;
        double totalHayFilLevel = 0;
        double totalGrassFillLevel = 0;
        double totalSilageFillLevel = 0;

        // bale counters
        int strawCounter = 0;
        int hayCounter = 0;
        int grassCounter = 0;
        int silageCounter = 0;

        try {
            for (Item item : items.getItems()) {
                // change coordinate gathered from XML file from string to Coordinate class
                item.setPosition(new Coordinate().createCoordinate(item.getPos()));

                // check if the class name is of type Bale
                if (item.getClassName().equals("Bale")) {

                    switch (item.getFillType()) {
                        case "STRAW": totalStrawFillLevel += item.getFillLevel(); strawCounter++; break;
                        case "DRYGRASS_WINDROW": totalHayFilLevel += item.getFillLevel(); hayCounter++; break;
                        case "GRASS": totalGrassFillLevel += item.getFillLevel(); grassCounter++; break;
                        case "SILAGE": totalSilageFillLevel += item.getFillLevel(); silageCounter++; break;
                    }
                }
            }

            // add all bale values to DB
            baleRepository.save(new Bale(null, strawCounter, "straw", totalStrawFillLevel));
            baleRepository.save(new Bale(null, hayCounter, "hay", totalHayFilLevel));
            baleRepository.save(new Bale(null, grassCounter, "grass", totalGrassFillLevel));
            baleRepository.save(new Bale(null, silageCounter, "silage", totalSilageFillLevel));

        } catch (NullPointerException e) {
            System.out.println("No items found");
        }
    }

}
