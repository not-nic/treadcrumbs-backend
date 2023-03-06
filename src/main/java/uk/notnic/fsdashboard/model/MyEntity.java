package uk.notnic.fsdashboard.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public MyEntity() {

    }

    public MyEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
