package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Farms.Farm;
import uk.notnic.fsdashboard.model.Farms.Farms;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;
import uk.notnic.fsdashboard.model.Farms.Statistics;
import uk.notnic.fsdashboard.repository.FarmRepository;
import uk.notnic.fsdashboard.repository.FinanceRepository;
import uk.notnic.fsdashboard.repository.StatisticsRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class FarmService implements ServiceHelper {
    private final FarmRepository farmRepository;
    private final FinanceRepository financeRepository;
    private final StatisticsRepository statisticsRepository;

    @Autowired
    public FarmService(FarmRepository farmRepository, FinanceRepository financeRepository, StatisticsRepository statisticsRepository) {
        this.farmRepository = farmRepository;
        this.financeRepository = financeRepository;
        this.statisticsRepository = statisticsRepository;
    }

    public List<Farm> getAllFarms() {
        return farmRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);

        JAXBContext jaxbContext = JAXBContext.newInstance(Farms.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Farms farms = (Farms) jaxbUnmarshaller.unmarshal(file);
        Farm farm = farms.getFarm();
        Statistics statistics = farms.getFarm().getStatistics();

        farmRepository.save(farm);
        statisticsRepository.save(statistics);

        for (FinanceStats day : farms.getFarm().getFinances().getFinanceStatsList()) {
            financeRepository.save(day);
        }
    }

}
