package uk.notnic.fsdashboard.model.Notes;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "notes")
@SequenceGenerator(name = "note_seq", allocationSize = 1)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    private Long id;
    private String author;
    private String contents;
    private Boolean generated;
    private LocalDateTime created;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection
    @CollectionTable(name = "note_additional_data", joinColumns = @JoinColumn(name = "note_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> additionalNoteData = new HashMap<>();

    public Note() {
    }

    public Note(Long id, String author, String contents, Boolean generated, LocalDateTime created, Map<String, String> additionalNoteData) {
        this.id = id;
        this.author = author;
        this.contents = contents;
        this.generated = generated;
        this.created = created;
        this.additionalNoteData = additionalNoteData;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(Boolean generated) {
        this.generated = generated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Map<String, String> getAdditionalNoteData() {
        return additionalNoteData;
    }

    public void setAdditionalNoteData(Map<String, String> additionalNoteData) {
        this.additionalNoteData = additionalNoteData;
    }
}
