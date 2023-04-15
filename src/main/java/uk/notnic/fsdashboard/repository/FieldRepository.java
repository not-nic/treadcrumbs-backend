package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Fields.Field;

import java.util.List;
@Repository
public interface FieldRepository extends CrudRepository<Field, Long> {
    List<Field> findAll();
}
