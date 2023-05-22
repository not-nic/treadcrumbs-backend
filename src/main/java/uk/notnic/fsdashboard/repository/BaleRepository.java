package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import uk.notnic.fsdashboard.model.Items.Bale;

import java.util.List;

public interface BaleRepository extends CrudRepository<Bale, Long> {

    List<Bale> findAll();
}
