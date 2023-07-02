package uk.notnic.fsdashboard.XmlAdapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EnabledAdapter extends XmlAdapter<String, Boolean> {

    @Override
    public Boolean unmarshal(String value) throws Exception {
        return "true".equals(value);
    }

    public String marshal(Boolean value) throws Exception {
        return value ? "true" : "false";
    }
}
