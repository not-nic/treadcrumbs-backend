package uk.notnic.fsdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Fields.Field;
import uk.notnic.fsdashboard.model.Fields.Fields;
import uk.notnic.fsdashboard.repository.FieldRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Service
public class FieldService extends ServiceHelper {

    private final FieldRepository fieldRepository;

    @Autowired
    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public void createEntityFromXML(String filepath) throws JAXBException {
        File file = new File(filepath);
        JAXBContext jaxbContext = JAXBContext.newInstance(Fields.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Fields fields = (Fields) jaxbUnmarshaller.unmarshal(file);

        for (Field field : fields.getFields()) {
            Field newField = new Field(field.getPlannedFruit());
            fieldRepository.save(newField);
        }
    }
}
