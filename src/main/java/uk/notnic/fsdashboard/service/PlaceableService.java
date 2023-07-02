package uk.notnic.fsdashboard.service;

import org.fusesource.jansi.Ansi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Coordinate;
import uk.notnic.fsdashboard.model.Items.Items;
import uk.notnic.fsdashboard.model.Placeables.Placeable;
import uk.notnic.fsdashboard.model.Placeables.Placeables;
import uk.notnic.fsdashboard.repository.PlaceableRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class PlaceableService implements ServiceHelper {

    private final PlaceableRepository placeableRepository;

    @Autowired
    public PlaceableService(PlaceableRepository placeableRepository) {
        this.placeableRepository = placeableRepository;
    }

    public List<Placeable> getAllPlaceables() {
        return placeableRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);

        JAXBContext jaxbContext = JAXBContext.newInstance(Placeables.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Placeables placeables = (Placeables) jaxbUnmarshaller.unmarshal(file);

        for (Placeable placeable : placeables.getPlaceables()) {

            // set position to helper coordinate class.
            placeable.setPosition(new Coordinate().createCoordinate(placeable.getPos()));

            // save to repo
            placeableRepository.save(placeable);
        }
    }
}
