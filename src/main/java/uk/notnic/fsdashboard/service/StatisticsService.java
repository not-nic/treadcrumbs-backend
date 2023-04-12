package uk.notnic.fsdashboard.service;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Statistics;
import uk.notnic.fsdashboard.repository.StatisticsRepository;

import java.io.File;
import java.util.List;

@Service
public class StatisticsService extends ServiceHelper {

    private final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void createEntityFromXML(String filepath) throws DocumentException {
        File file = new File(filepath);

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);

        List<Node> listOfStats = document.selectNodes("//farms/farm/statistics");

        for (Node stat : listOfStats) {
            Long id = null;
            Double fuelUsage = Double.parseDouble(stat.valueOf("fuelUsage"));
            Double seedUsage = Double.parseDouble(stat.valueOf("seedUsage"));
            Double sprayUsage = Double.parseDouble(stat.valueOf("sprayUsage"));
            Double workedHectares = Double.parseDouble(stat.valueOf("workedHectares"));
            Double workedTime = Double.parseDouble(stat.valueOf("workedTime"));
            Double playTime = Double.parseDouble(stat.valueOf("playTime"));
            Double distanceDriven = Double.parseDouble(stat.valueOf("traveledDistance"));

            Statistics statistic = new Statistics(id, fuelUsage, seedUsage, sprayUsage, workedHectares, workedTime, playTime, distanceDriven);
            statisticsRepository.save(statistic);
        }
    }
}
