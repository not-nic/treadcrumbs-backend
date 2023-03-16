package uk.notnic.fsdashboard.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Attachments;
import uk.notnic.fsdashboard.model.Coordinate;
import uk.notnic.fsdashboard.model.Vehicle;
import uk.notnic.fsdashboard.repository.VehicleRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // creates entity from reading a xml file.
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
            Long id = vehicleRepository.count() + 1;
            String name = vehicle.valueOf("@filename");
            String licensePlate = vehicle.valueOf("licensePlates/@characters");
            String position = vehicle.valueOf("component/@position");
            String lastJob = vehicle.valueOf("aiJobVehicle/lastJob/@type");
            String owned;
            Integer propertyState = Integer.parseInt(vehicle.valueOf("@propertyState"));
            Integer vehicleId = Integer.parseInt(vehicle.valueOf("@id"));
            Double price = Double.parseDouble(vehicle.valueOf("@price"));
            Double age = Double.parseDouble(vehicle.valueOf("@age"));
            Double operatingTime = Double.parseDouble(vehicle.valueOf("@operatingTime"));
            Double damage;
            Double fuel;

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

            // create a new entity with information, save it to repository.
            Vehicle vehicles = new Vehicle(id, name, licensePlate, lastJob, owned, new Coordinate().createCoordinate(position), vehicleId, drivable, currAttachment, price, age, damage, fuel, operatingTime);
            vehicleRepository.save(vehicles);
        }
    }

}
