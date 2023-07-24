package uk.notnic.fsdashboard.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Placeables.Silos.SiloStorageNode;
import uk.notnic.fsdashboard.repository.SiloRepository;

import java.util.List;

@Service
public class SiloService {

    private final SiloRepository siloRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public SiloService(SiloRepository siloRepository) {
        this.siloRepository = siloRepository;
    }

    public List<SiloStorageNode> getAllSilos() {
        return siloRepository.findAll();
    }

    public SiloStorageNode createSilo(SiloStorageNode silo) {
        return siloRepository.save(silo);
    }

    public void DeleteSiloById(long id) {
        siloRepository.deleteById(id);
    }
}
