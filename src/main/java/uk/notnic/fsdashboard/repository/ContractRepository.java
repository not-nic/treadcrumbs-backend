package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Contracts.Mission;

import java.util.List;

@Repository
public interface ContractRepository extends CrudRepository<Mission, Long> {
    List<Mission> findAll();
}
