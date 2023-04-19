package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Vehicles.Tractor;

import java.util.List;

@Repository
public interface TractorRepository extends CrudRepository<Tractor, Long> {
    List<Tractor> findAll();
}
