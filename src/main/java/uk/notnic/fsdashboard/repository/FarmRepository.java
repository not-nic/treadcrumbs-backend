package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Farm;

import java.util.List;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {
    List<Farm> findAll();
}
