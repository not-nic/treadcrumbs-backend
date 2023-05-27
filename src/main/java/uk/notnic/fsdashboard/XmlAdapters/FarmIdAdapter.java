package uk.notnic.fsdashboard.XmlAdapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FarmIdAdapter extends XmlAdapter<String, Boolean> {
    @Override
    public Boolean unmarshal(String value) throws Exception {
        return "1".equals(value);
    }

    @Override
    public String marshal(Boolean value) throws Exception {
        return value ? "1" : "0";
    }
}
