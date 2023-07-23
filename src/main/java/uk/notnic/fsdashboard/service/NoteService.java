package uk.notnic.fsdashboard.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Notes.Note;
import uk.notnic.fsdashboard.repository.NoteRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepository.findById(id);
    }

    public void createNote(Note note) {
        note.setCreated(LocalDateTime.now());

        noteRepository.save(note);
    }

    public Note updateNote(long id, Note updatedNote) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Note with ID %s not found", id)));

        updatedNote.setCreated(existingNote.getCreated());

        modelMapper.map(updatedNote, existingNote);

        return noteRepository.save(existingNote);
    }

    public void DeleteNoteById(long id) {
        noteRepository.deleteById(id);
    }
}
