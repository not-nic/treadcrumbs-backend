package uk.notnic.fsdashboard.model.Fields;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fields {

    @XmlElement(name = "field")
    private List<Field> fieldList;

    public Fields() {
    }

    public Fields(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Field> getFields() {
        return fieldList;
    }
}
