package uk.notnic.fsdashboard.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Farm;
import uk.notnic.fsdashboard.repository.FarmRepository;

import java.io.File;
import java.util.List;

@Service
public class FarmService extends ServiceHelper {

    private final FarmRepository farmRepository;

    @Autowired
    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    public void createFarm(Farm farm) {
        farmRepository.save(farm);
    }

    @Override
    public void createEntityFromXML(String filepath) throws DocumentException {

        File file = new File(filepath);

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        List<Node> listOfFarms = document.selectNodes("//farms/farm");

        for (Node farm : listOfFarms) {

            Long id = null;
            Integer farmId = Integer.parseInt(farm.valueOf("@farmId"));
            String farmName = farm.valueOf("@name");
            String userId = "player";
            String playerName = "name";
            Double loan = Double.parseDouble(farm.valueOf("@loan"));
            Double money = Double.parseDouble(farm.valueOf("@money"));

            for (Node player : farm.selectNodes("/players")) {
                userId = player.valueOf("@uniqueUserId");
                playerName = player.valueOf("@lastNickname");
            }

            Farm farmEntity = new Farm(id, farmId, farmName, userId, playerName, loan, money);
            farmRepository.save(farmEntity);
        }
    }
}
