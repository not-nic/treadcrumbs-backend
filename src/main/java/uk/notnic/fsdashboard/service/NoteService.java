package uk.notnic.fsdashboard.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.model.Notes.Note;
import uk.notnic.fsdashboard.repository.FieldRepository;
import uk.notnic.fsdashboard.repository.NoteRepository;
import uk.notnic.fsdashboard.repository.TractorRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final FieldRepository fieldRepository;
    private final TractorRepository tractorRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public NoteService(NoteRepository noteRepository, FieldRepository fieldRepository, TractorRepository tractorRepository) {
        this.noteRepository = noteRepository;
        this.fieldRepository = fieldRepository;
        this.tractorRepository = tractorRepository;
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

    private List<String> findArguments(String noteContents) {
        List<String> matches = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b(\\S+:\\S+)");
        Matcher matcher = pattern.matcher(noteContents);

        while (matcher.find()) {
            String match = matcher.group(1);
            matches.add(match);
        }

        return matches;
    }

    private Object findNoteValues(String foundArgument) {
        Pattern pattern = Pattern.compile(":\\s*([\\w\\d]+)");
        Matcher matcher = pattern.matcher(foundArgument);

        if (matcher.find()) {
            String value = matcher.group(1);
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e) {
                return value;
            }
        }

        return null;
    }

    public void createFieldworkCommand(Note note) {

        note.setCreated(LocalDateTime.now());
        StringBuilder newContents = new StringBuilder();

        String contents = note.getContents();

        List<String> arguments = findArguments(contents);

        for (String argument : arguments) {
            Object value = findNoteValues(argument);

            if (value instanceof Long argumentValue) {
                String argumentName = argument.split(":")[0];
                String commandType = contents.split(" ")[0];

                if ("field".equals(argumentName)) {
                    fieldRepository.findById(argumentValue).ifPresent(field -> newContents.append(String.format("%s field %s", commandType, field.getFarmlandId())));

                } else if ("vehicle".equals(argumentName)) {
                    tractorRepository.findById(argumentValue).ifPresent(tractor -> newContents.append(String.format(" using %s.", tractor.getName())));
                }
            } else if (value instanceof String cropName) {
                newContents.append(String.format(" with [%s]", cropName));
            }
        }

        note.setContents(newContents.toString());
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
