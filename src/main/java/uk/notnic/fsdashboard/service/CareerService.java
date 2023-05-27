package uk.notnic.fsdashboard.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Career;
import uk.notnic.fsdashboard.repository.CareerRepository;

import java.io.File;
import java.util.List;

@Service
public class CareerService implements ServiceHelper {

    private final CareerRepository careerRepository;

    @Autowired
    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<Career> getCareer() {
        return careerRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws DocumentException {

        File file = new File(filepath);

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        String xmlPath = "//careerSavegame/settings/";

        Long id = null;
        String name = document.valueOf(xmlPath + "savegameName");
        String mapTitle = document.valueOf(xmlPath + "mapTitle");
        Integer difficulty = Integer.parseInt(document.valueOf(xmlPath + "economicDifficulty"));
        String dateCreated = document.valueOf(xmlPath + "saveDateFormatted");

        Career career = new Career(id, name, mapTitle, difficulty, dateCreated);
        careerRepository.save(career);
    }
}
