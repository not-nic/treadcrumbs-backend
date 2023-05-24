package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Farms.Statistics;

import java.util.List;

@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {
    List<Statistics> findAll();
}
