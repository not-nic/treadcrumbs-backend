package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;

import java.util.List;

public interface FinanceRepository extends CrudRepository<FinanceStats, Long> {
    List<FinanceStats> findAll();
}
