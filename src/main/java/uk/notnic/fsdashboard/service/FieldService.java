package uk.notnic.fsdashboard.service;

import org.dom4j.DocumentException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Fields.EnvironmentalScores.Farmland;
import uk.notnic.fsdashboard.model.Fields.Farmlands.Farmlands;
import uk.notnic.fsdashboard.model.Fields.Farmlands.PlayerFarmland;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.model.Fields.PrecisionFarming;
import uk.notnic.fsdashboard.repository.FieldRepository;

import javax.persistence.EntityNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FieldService implements ServiceHelper {

    private final FieldRepository fieldRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws DocumentException, JAXBException {

    }

    public List<Field> getOwnedFields() {
        return fieldRepository.findAllByOwnedTrue();
    }

    public Optional<Field> getFieldById(long id) {
        return fieldRepository.findById(id);
    }

    public void createField(Field field) {
        fieldRepository.save(field);
    }

    public Field updateField(long id, Field updatedField) {

        Field existingField = fieldRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Field with ID %s not found", id)));

        modelMapper.map(updatedField, existingField);

        return fieldRepository.save(existingField);
    }

    public void DeleteFieldById(long id) {
        fieldRepository.deleteById(id);
    }

    @Override
    public void createEntityFromXMLs(String... filenames) throws JAXBException {
        File farmlandPath = new File(filenames[0]);
        File precisionFarmingPath = new File(filenames[1]);

        JAXBContext farmlandsContext = JAXBContext.newInstance(Farmlands.class);
        Unmarshaller farmlandUnmarshaller = farmlandsContext.createUnmarshaller();
        Farmlands farmlands = (Farmlands) farmlandUnmarshaller.unmarshal(farmlandPath);

        JAXBContext precisionFarmingContext = JAXBContext.newInstance(PrecisionFarming.class);
        Unmarshaller PFUnmarshaller = precisionFarmingContext.createUnmarshaller();
        PrecisionFarming precisionFarmings = (PrecisionFarming) PFUnmarshaller.unmarshal(precisionFarmingPath);

        // loop over all farmlands from farmland.xml
        for (PlayerFarmland playerFarmland : farmlands.getPlayerFarmlands()) {

            Field newField;
            boolean foundMatch = false;

            // loop over all farmlands found in tillage of precisionfarming.xml
            for (Farmland farmland : precisionFarmings.getEnvironmentalScore().getTillage().getFarmlandList()) {

                // check if the farmlandId and the playerFarmlandId are the same
                // if so we can get information to fill out most of the fields.
                if (playerFarmland.getId().equals(farmland.getFarmlandId())) {

                    if (!Stream.of(farmland).allMatch(Objects::isNull)) {
                        // create new field for player, some attributes are false as
                        // Farming Simulator doesn't provide them by default.
                        newField = new Field(null, null, "", farmland.getFarmlandId(),
                                1, farmland.getFieldAreaHa(), 140.0, 7.00000,
                                playerFarmland.getOwned(), false, false, false);
                        fieldRepository.save(newField);
                        foundMatch = true;
                        break;
                    }

                    // create new field for player, some attributes are false as
                    // Farming Simulator doesn't provide them by default.
                    newField = new Field(null, null,
                            "this is a farmland and cannot grow crops", farmland.getFarmlandId(),
                            null, null, 0.0, 0.0,
                            playerFarmland.getOwned(), false, false, false);
                    fieldRepository.save(newField);
                    foundMatch = true;
                    break;
                }
            }

            if (!foundMatch) {
                // create field with stats from just playerFarmland
                newField = new Field(null, "", "", playerFarmland.getId(),
                        1, null, 0.00, 5.00000,
                        playerFarmland.getOwned(), false, false, false);

                fieldRepository.save(newField);
            }
        }
    }
}

