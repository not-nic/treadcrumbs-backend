package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import uk.notnic.fsdashboard.model.Farms.Statistics;

import java.util.List;

public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
    List<Statistics> findAll();
}
