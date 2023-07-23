package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Farms.Farm;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {
    List<Farm> findAll();

    Optional<Farm> findById(long id);
}
