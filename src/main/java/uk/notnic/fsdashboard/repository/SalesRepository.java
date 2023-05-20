package uk.notnic.fsdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.notnic.fsdashboard.model.Sales.Item;
import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<Item,Long> {
    List<Item> findAll();
}
