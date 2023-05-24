package uk.notnic.fsdashboard;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<String, Boolean> {
    @Override
    public Boolean unmarshal(String value) throws Exception {
        return "1.000000".equals(value);
    }

    @Override
    public String marshal(Boolean value) throws Exception {
        return value ? "1.000000" : "1.000000";
    }
}
