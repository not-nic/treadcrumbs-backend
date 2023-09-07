package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Vehicles.Tractor;

import java.util.List;
import java.util.Optional;

@Repository
public interface TractorRepository extends CrudRepository<Tractor, Long> {
    List<Tractor> findAll();
    Optional<Tractor> findById(Long id);
    List<Tractor> findAllByFarmIdEquals(Integer farmId);
}
