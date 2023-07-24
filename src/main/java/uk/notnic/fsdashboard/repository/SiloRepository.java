package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import uk.notnic.fsdashboard.model.Placeables.Silos.SiloStorageNode;

import java.util.List;
import java.util.Optional;

public interface SiloRepository extends CrudRepository<SiloStorageNode, Long> {
    List<SiloStorageNode> findAll();
    Optional<SiloStorageNode> deleteById(long id);
}
