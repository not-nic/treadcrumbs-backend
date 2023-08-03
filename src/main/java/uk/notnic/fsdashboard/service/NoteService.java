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
import java.util.*;
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

    // get arguments from a command that are joined with a `:`
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

    // get the value of a command after the `:`
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

        // create list of arguments joined by ':' from /command
        List<String> arguments = findArguments(contents);

        for (String argument : arguments) {

            // get value after ':'
            Object value = findNoteValues(argument);

            // check if the current value is a Long
            if (value instanceof Long argumentValue) {
                String argumentName = argument.split(":")[0];

                // get command type and remove `/` from the beginning.
                String commandType = contents.split(" ")[0].substring(1);


                if ("field".equals(argumentName)) {
                    // find the field by its id, if it exists add it to the string builder.
                    fieldRepository.findById(argumentValue).ifPresent(field -> newContents.append(String.format("%s field %s", commandType, field.getFarmlandId())));

                } else if ("vehicle".equals(argumentName)) {
                    // find the vehicle by its id, if it exists add it to the string builder.
                    tractorRepository.findById(argumentValue).ifPresent(tractor -> newContents.append(String.format(" using %s.", tractor.getName())));
                }
            } else if (value instanceof String cropName) {
                // check if a crop exists as a 'optional' argument for seed jobs.
                newContents.append(String.format(" with [%s]", cropName));

                // check if the additional note data is not empty
                if (!note.getAdditionalNoteData().isEmpty()) {

                    // take the two arguments for seeding (field size & seeds per Ha) which are passed in from the frontend.
                    Map<String, String> newNoteData = new HashMap<>();
                    Double[] fieldSizeWrapper = {0.0};
                    double seedsPerHa = 0.0;

                    fieldSizeWrapper[0] = 0.0;

                    // iterate through each entry in additional note data
                    for (Map.Entry<String, String> entry : note.getAdditionalNoteData().entrySet()) {
                        String additionalDataKey = entry.getKey();
                        String additionalDataValue = entry.getValue();

                        // check if the current key equals fieldId.
                        if (additionalDataKey.equals("fieldId")) {
                            Long fieldId = Long.parseLong(additionalDataValue);

                            Optional<Field> fieldOptional = fieldRepository.findById(fieldId);

                            // check if the field exists in the repository.
                            if (fieldOptional.isPresent()) {
                                Field field = fieldOptional.get();
                                // check if the field size is not null
                                try {
                                    fieldSizeWrapper[0] = field.getFieldSizeHa();
                                } catch (NumberFormatException e) {
                                    fieldSizeWrapper[0] = 0.0;
                                }
                            }
                        }

                        // check if the current key equals seedsPerHa.
                        if (additionalDataKey.equals("seedsPerHa")) {
                            // Check if the seedsPerHa is a valid number
                            try {
                                seedsPerHa = Double.parseDouble(additionalDataValue);
                            } catch (NumberFormatException e) {
                                seedsPerHa = 0.0;
                            }
                        }

                        // add seed costs to the new data object.
                        newNoteData.put("Seed Costs", Math.round((fieldSizeWrapper[0] / 10000) * seedsPerHa) + "l");
                    }

                    // replace the arguments fieldId & seeds per Ha with the seed costs.
                    note.setAdditionalNoteData(newNoteData);
                }
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
