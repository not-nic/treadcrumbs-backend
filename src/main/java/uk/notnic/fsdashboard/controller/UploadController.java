package uk.notnic.fsdashboard.controller;

import org.dom4j.DocumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.notnic.fsdashboard.model.*;
import uk.notnic.fsdashboard.model.Contracts.Mission;
import uk.notnic.fsdashboard.model.Farms.Farm;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;
import uk.notnic.fsdashboard.model.Farms.Statistics;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.model.Items.Bale;
import uk.notnic.fsdashboard.model.Sales.Sale;
import uk.notnic.fsdashboard.model.Vehicles.Implement;
import uk.notnic.fsdashboard.model.Vehicles.Tractor;
import uk.notnic.fsdashboard.repository.*;
import uk.notnic.fsdashboard.service.*;

import javax.xml.bind.JAXBException;
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
    private final FarmService farmService;
    private final FarmRepository farmRepository;
    private final StatisticsRepository statisticsRepository;
    private final FinanceRepository financeRepository;
    private final FieldService fieldService;
    private final FieldRepository fieldRepository;
    private final ImplementRepository implementRepository;
    private final TractorRepository tractorRepository;
    private final SalesRepository salesRepository;
    private final SalesService salesService;
    private final BaleRepository baleRepository;
    private final ItemService itemService;
    private final ContractService contractService;
    private final ContractRepository contractRepository;

    private String saveGameDirectory;

    public UploadController(VehicleService vehicleService, CareerService careerService, CareerRepository careerRepository,
                            FarmService farmService, FarmRepository farmRepository, StatisticsRepository statisticsRepository,
                            FinanceRepository financeRepository, FieldService fieldService, FieldRepository fieldRepository,
                            ImplementRepository implementRepository, TractorRepository tractorRepository,
                            SalesRepository salesRepository, SalesService salesService, BaleRepository baleRepository,
                            ItemService itemService, ContractService contractService, ContractRepository contractRepository) {
        this.vehicleService = vehicleService;
        this.careerService = careerService;
        this.careerRepository = careerRepository;
        this.farmService = farmService;
        this.farmRepository = farmRepository;
        this.statisticsRepository = statisticsRepository;
        this.financeRepository = financeRepository;
        this.fieldService = fieldService;
        this.fieldRepository = fieldRepository;
        this.implementRepository = implementRepository;
        this.tractorRepository = tractorRepository;
        this.salesRepository = salesRepository;
        this.salesService = salesService;
        this.baleRepository = baleRepository;
        this.itemService = itemService;
        this.contractService = contractService;
        this.contractRepository = contractRepository;
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
        List<Implement> implement = implementRepository.findAll();
        List<Tractor> tractor = tractorRepository.findAll();
        List<Statistics> stats = statisticsRepository.findAll();
        List<Farm> farms = farmRepository.findAll();
        List<FinanceStats> finances = financeRepository.findAll();
        List<Field> fields = fieldRepository.findAll();
        List<Sale> sales = salesRepository.findAll();
        List<Bale> bales = baleRepository.findAll();
        List<Mission> contracts = contractRepository.findAll();

        response.put("career", career);
        response.put("implements", implement);
        response.put("tractors", tractor);
        response.put("stats", stats);
        response.put("farms", farms);
        response.put("finances", finances);
        response.put("fields", fields);
        response.put("sales", sales);
        response.put("items", bales);
        response.put("contracts", contracts);

        return response;
    }

    public void readFile(String fullPath) throws DocumentException, JAXBException {
        vehicleService.createEntityFromXML(fullPath + "/vehicles.xml");
        careerService.createEntityFromXML(fullPath + "/careerSavegame.xml");
        farmService.createEntityFromXML(fullPath + "/farms.xml");
        fieldService.createEntityFromXMLs(fullPath + "/farmland.xml", fullPath + "/precisionFarming.xml");
        salesService.createEntityFromXML(fullPath + "/sales.xml");
        itemService.createEntityFromXML(fullPath + "/items.xml");
        contractService.createEntityFromXML(fullPath + "/missions.xml");

        System.out.println(String.format("Items added to db: %s | %s | %s | %s | %s | %s | %s | %s",
                careerRepository.count(), farmRepository.count(),
                financeRepository.count(), statisticsRepository.count(), fieldRepository.count(),
                salesRepository.count(), baleRepository.count(), contractRepository.count()
        ));
    }

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file ) {

        String fileName = file.getOriginalFilename();
        String filePath = "C:\\Users\\Nick\\IdeaProjects\\fsdashboard\\uploads\\";
        int uploadedFiles = 0;

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
                        uploadedFiles++;
                    }
                }
                else {
                    System.out.println("Discarding " + entryName);
                }
            }

            readFile(saveGameDirectory);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (DocumentException | JAXBException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(String.format("%s files uploaded successfully.", uploadedFiles));
    }
}
