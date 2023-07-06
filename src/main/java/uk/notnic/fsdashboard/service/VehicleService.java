package uk.notnic.fsdashboard.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Vehicles.*;
import uk.notnic.fsdashboard.model.Coordinate;
import uk.notnic.fsdashboard.repository.ImplementRepository;
import uk.notnic.fsdashboard.repository.TractorRepository;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements ServiceHelper {

    private final TractorRepository tractorRepository;
    private final ImplementRepository implementRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public VehicleService(TractorRepository tractorRepository, ImplementRepository implementRepository) {
        this.tractorRepository = tractorRepository;
        this.implementRepository = implementRepository;
    }

    public List<Implement> getAllImplements() {
        return implementRepository.findAll();
    }

    public List<Tractor> getAllTractors() {
        return tractorRepository.findAll();
    }

    public Optional<Implement> getImplementById(long id) {
        return implementRepository.findById(id);
    }

    public Optional<Tractor> getTractorById(long id) {
        return tractorRepository.findById(id);
    }

    public void createTractor(Tractor tractor) {
        tractorRepository.save(tractor);
    }

    public Tractor updateTractor(long id, Tractor updatedTractor) {

        Tractor existingTractor = tractorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Tractor with ID: %s not found", id)));

        modelMapper.map(updatedTractor, existingTractor);

        return tractorRepository.save(existingTractor);
    }

    public Implement updateImplement(Long id, Implement updatedImplement) {

        Implement existingImplement = implementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Implement with ID: %s not found", id)));

        modelMapper.map(updatedImplement, existingImplement);

        return implementRepository.save(existingImplement);
    }

    // creates entity from reading a xml file.
    @Override
    public void createEntityFromXML(String filepath) throws DocumentException {

        File file = new File(filepath);

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        // look for all tags starting with vehicles
        List<Node> listOfVehicles = document.selectNodes("//vehicles/vehicle");
        List<Node> listOfAttachments = document.selectNodes("//vehicles/attachments");


        // for each vehicle in the vehicles list
        for (Node vehicle : listOfVehicles) {

            // Xpath locations of information in vehicles
            Long id = null;
            String name = vehicle.valueOf("@filename");
            String licensePlate = vehicle.valueOf("licensePlates/@characters");
            String position = vehicle.valueOf("component/@position");
            String lastJob = vehicle.valueOf("aiJobVehicle/lastJob/@type");
            String selectedFruitType = vehicle.valueOf("sowingMachine/@selectedSeedFruitType");

            String owned;
            Integer propertyState = Integer.parseInt(vehicle.valueOf("@propertyState"));
            Integer vehicleId = Integer.parseInt(vehicle.valueOf("@id"));
            Integer farmId = Integer.parseInt(vehicle.valueOf("@farmId"));
            Double price = Double.parseDouble(vehicle.valueOf("@price"));
            Double age = Double.parseDouble(vehicle.valueOf("@age"));
            Double operatingTime = Double.parseDouble(vehicle.valueOf("@operatingTime"));
            Double damage;
            Double fuel;

            FillUnit fillUnit = new FillUnit();
            ArrayList<FillUnit.Unit> units = new ArrayList<>();
            FillUnit.Unit unit;

            Boolean sowingMachine = !vehicle.valueOf("sowingMachine").equals(null);
            Boolean drivable = !vehicle.valueOf("drivable/@cruiseControl").equals("");

            ArrayList<Integer> attachments = new ArrayList<>();
            Attachments currAttachment = new Attachments(vehicleId, attachments);

            // find fuel level of tractor
            if (vehicle.valueOf("fillUnit/unit[@fillType='DIESEL']/@fillLevel").equals("") ) {
                fuel = null;
            } else {
                fuel = Double.parseDouble(vehicle.valueOf("fillUnit/unit[@fillType='DIESEL']/@fillLevel"));
            }

            // find damage level of tractor
            if (vehicle.valueOf("wearable/@damage").equals("")) {
                damage = null;
            } else {
                damage = Double.parseDouble(vehicle.valueOf("wearable/@damage"));
            }

            // get property state of vehicle
            switch(propertyState) {
                case 0: owned = "unowned"; break;
                case 1: owned = "owned"; break;
                case 2: owned = "leased"; break;
                default: owned = "unknown";
            }

            for (Node vehicleUnit : vehicle.selectNodes("fillUnit/*")) {

//                System.out.println("current vehicle unit: " +  vehicleUnit);

                String fillType = vehicleUnit.valueOf("@fillType");
                Double fillLevel;

//                System.out.println("Current fill Type: " + fillType);

                if (vehicleUnit.valueOf("@fillLevel").equals("")) {
                    fillLevel = 0.0;
                } else {
                    fillLevel = Double.parseDouble(vehicleUnit.valueOf("@fillLevel"));
                }

                unit = new FillUnit.Unit(fillType, fillLevel);
                units.add(unit);
                fillUnit.setUnits(units);
            }

            // vehicle attachments
            for (Node attachment : listOfAttachments) {
                if (vehicleId.equals(Integer.parseInt(attachment.valueOf("@rootVehicleId")))) {

                    List<Node> attachmentChildren = attachment.selectNodes("attachment");

                    // loop over multiple nodes
                    for (Node connectedAttachment : attachmentChildren) {
                        Integer attachmentId = Integer.parseInt(connectedAttachment.valueOf("@attachmentId"));
                        attachments.add(attachmentId);
                    }

                    // create attachment link between the root and its children.
                    currAttachment.createAttachmentLink(currAttachment);
                }
            }

            if (drivable.equals(true)) {
                // create a new entity with information, save it to repository.
                Tractor tractor = new Tractor(id, name, owned, age, price, operatingTime, damage, farmId,
                        new Coordinate().createCoordinate(position), licensePlate, lastJob, fuel, currAttachment);
                tractorRepository.save(tractor);
            } else if (sowingMachine) {
                // create a new entity with information, save it to repository.
                Implement implement = new Implement(id, name, owned, age, price, operatingTime, damage, farmId,
                        new Coordinate().createCoordinate(position), selectedFruitType, fillUnit);
                implementRepository.save(implement);
            }
        }
    }
}
