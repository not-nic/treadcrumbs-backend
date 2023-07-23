package uk.notnic.fsdashboard.controller;

import org.springframework.web.bind.annotation.*;
import uk.notnic.fsdashboard.model.Notes.Note;
import uk.notnic.fsdashboard.service.NoteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public List<Note> allNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> findNoteById(@PathVariable long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/notes/{id}")
    public Note updateNote(@PathVariable long id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    @PostMapping("/notes")
    public String createNote(@RequestBody Note note) {
        noteService.createNote(note);
        return String.format("Created Note %s", note.getId());
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNoteById(@PathVariable long id) {
        noteService.DeleteNoteById(id);

        return String.format("Note %s Deleted", id);
    }
}
