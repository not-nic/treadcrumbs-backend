package uk.notnic.fsdashboard.model.Notes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@SequenceGenerator(name = "note_seq", allocationSize = 1)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    private Long id;
    private String author;
    private String contents;
    private LocalDateTime created;

    public Note() {
    }

    public Note(Long id, String author, String contents, LocalDateTime created) {
        this.id = id;
        this.author = author;
        this.contents = contents;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
