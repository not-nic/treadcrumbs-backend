package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uk.notnic.fsdashboard.service.VehicleService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@RestController
@RequestMapping("/api")
public class UploadController {

    private final VehicleService vehicleService;

    public UploadController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
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

                    // get uploaded file name
                    String[] splitPath = outputFile.toString().split("\\\\");
                    String directory = splitPath[splitPath.length-2];

                    if (entryName.equals(directory + "/vehicles.xml")) {
                        // Create dummy entity from vehicle.xml
                        vehicleService.createEntityFromXML(filePath + entryName);

                        // TODO: implement switch case for each file...

                    }
                }
                else {
                    System.out.println("Discarding " + entryName);
                }
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("File read successfully.");
    }
}
