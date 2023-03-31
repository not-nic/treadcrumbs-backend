package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.notnic.fsdashboard.model.Career;
import uk.notnic.fsdashboard.model.Vehicle;
import uk.notnic.fsdashboard.repository.CareerRepository;
import uk.notnic.fsdashboard.repository.VehicleRepository;
import uk.notnic.fsdashboard.service.CareerService;
import uk.notnic.fsdashboard.service.VehicleService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@RestController
@RequestMapping("/api")
public class UploadController {

    private final VehicleService vehicleService;
    private final CareerService careerService;
    private final CareerRepository careerRepository;
    private final VehicleRepository vehicleRepository;

    private String saveGameDirectory;

    public UploadController(VehicleService vehicleService, CareerService careerService, CareerRepository careerRepository, VehicleRepository vehicleRepository) {
        this.vehicleService = vehicleService;
        this.careerService = careerService;
        this.careerRepository = careerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public ArrayList<String> setXmlToMatch() {
        ArrayList<String> xmlToMatch = new ArrayList<>();

        xmlToMatch.add("careerSavegame.xml");
        xmlToMatch.add("economy.xml");
        xmlToMatch.add("farmland.xml");
        xmlToMatch.add("fields.xml");
        xmlToMatch.add("items.xml");
        xmlToMatch.add("missions.xml");
        xmlToMatch.add("placeables.xml");
        xmlToMatch.add("precisionFarming.xml");
        xmlToMatch.add("sales.xml");
        xmlToMatch.add("vehicles.xml");
        xmlToMatch.add("farms.xml");

        return xmlToMatch;
    }

    @GetMapping("/save-game")
    public Map<String, Object> getSaveGame() {
        Map<String, Object> response = new HashMap<>();

        List<Career> career = careerRepository.findAll();
        List<Vehicle> vehicles = vehicleRepository.findAll();

        response.put("career", career);
        response.put("vehicles", vehicles);

        return response;
    }

    public void readFile(String fullPath) throws DocumentException {
        vehicleService.createEntityFromXML(fullPath + "/vehicles.xml");
        careerService.createEntityFromXML(fullPath + "/careerSavegame.xml");

        System.out.println("Items added to vehiclesTable: " + vehicleRepository.count() + " | " + "Items added to CareerTable: " + careerRepository.count() );
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        String filePath = "C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\";

        if (!fileName.endsWith(".zip")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload your save game as a zip file.");
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream())) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String entryName = entry.getName();

                // check file extension is xml
                if (entryName.endsWith(".xml") && setXmlToMatch().contains(entryName.split("/")[1])) {
                    // save uploaded xml files.
                    File outputFile = new File(filePath + entryName);
                    saveGameDirectory = filePath + entryName.split("/")[0];

                    if (!outputFile.exists()) {
                        outputFile.getParentFile().mkdirs();
                        outputFile.createNewFile();
                    }

                    try (OutputStream out = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            out.write(buffer, 0, len);
                        }
                    }
                }
                else {
                    System.out.println("Discarding " + entryName);
                }
            }

            readFile(saveGameDirectory);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("File read successfully.");
    }
}
