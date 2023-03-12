package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.MyEntity;
import uk.notnic.fsdashboard.repository.MyEntityRepository;

import java.util.List;

@Service
public class MyEntityService {

    // initiate repository
    private final MyEntityRepository myEntityRepository;

    @Autowired
    public MyEntityService(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    // gets all entities from repository
    public List<MyEntity> getAllMyEntities() {
        return myEntityRepository.findAll();
    }

    public void deleteAllEntities() {
        myEntityRepository.deleteAll();
    }

    // create entity method
    public void createMyEntity(MyEntity myEntity) {
        myEntityRepository.save(myEntity);
    }

}
