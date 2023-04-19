package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Vehicles.Implement;

import java.util.List;

@Repository
public interface ImplementRepository extends CrudRepository<Implement, Long> {
    List<Implement> findAll();
}

