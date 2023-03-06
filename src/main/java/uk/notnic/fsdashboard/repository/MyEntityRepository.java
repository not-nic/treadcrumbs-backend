package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.MyEntity;

import java.util.List;

@Repository
public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
    List<MyEntity> findAll();

    void deleteAll();
}
