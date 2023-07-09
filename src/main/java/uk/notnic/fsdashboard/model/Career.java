package uk.notnic.fsdashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "career")
@SequenceGenerator(name="career_seq", allocationSize=1)
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "career_seq")
    private Long id;
    private String saveGameName;
    private String mapTitle;
    private Integer difficulty;
    private String dateCreated;

    public Career() {
    }

    public Career(Long id, String saveGameName, String mapTitle, Integer difficulty, String dateCreated) {
        this.id = id;
        this.saveGameName = saveGameName;
        this.mapTitle = mapTitle;
        this.difficulty = difficulty;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public String getSaveGameName() {
        return saveGameName;
    }

    public String getMapTitle() {
        return mapTitle;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setSaveGameName(String saveGameName) {
        this.saveGameName = saveGameName;
    }

    public void setMapTitle(String mapTitle) {
        this.mapTitle = mapTitle;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
