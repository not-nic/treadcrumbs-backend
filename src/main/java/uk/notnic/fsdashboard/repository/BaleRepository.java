package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Items.Bale;

import java.util.List;

@Repository
public interface BaleRepository extends CrudRepository<Bale, Long> {

    List<Bale> findAll();
}
