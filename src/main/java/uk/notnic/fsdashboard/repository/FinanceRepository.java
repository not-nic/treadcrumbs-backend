package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;

import java.util.List;
@Repository
public interface FinanceRepository extends CrudRepository<FinanceStats, Long> {
    List<FinanceStats> findAll();
}
