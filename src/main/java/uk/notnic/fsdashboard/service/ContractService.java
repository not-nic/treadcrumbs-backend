package uk.notnic.fsdashboard.service;

import org.fusesource.jansi.Ansi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Contracts.Mission;
import uk.notnic.fsdashboard.model.Contracts.Missions;
import uk.notnic.fsdashboard.repository.ContractRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class ContractService implements ServiceHelper {

    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Mission> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Missions.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Missions missions = (Missions) jaxbUnmarshaller.unmarshal(file);

        try {
            for (Mission mission : missions.getMissions()) {

                if (mission.getType().equals("harvest")) {
                    mission.getHarvest().calculatePercentageComplete(
                            mission.getHarvest().getExpectedLitres(), mission.getHarvest().getDepositedLitres()
                    );
                }

                contractRepository.save(mission);
            }
        } catch (NullPointerException e){
            System.out.println(Ansi.ansi().fgCyan().a(String.format("[INFO] %s: | No Contracts found.",
                    missions.getClass().getSimpleName())).reset());
        }
    }
}
