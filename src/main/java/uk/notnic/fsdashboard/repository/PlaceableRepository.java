package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Placeables.Placeable;

import java.util.List;

@Repository
public interface PlaceableRepository extends CrudRepository<Placeable, Long> {

    List<Placeable> findAll();
}
