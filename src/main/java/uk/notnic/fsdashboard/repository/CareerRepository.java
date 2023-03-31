package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Career;

import java.util.List;

@Repository
public interface CareerRepository extends CrudRepository<Career, Long> {
    List<Career> findAll();
}
