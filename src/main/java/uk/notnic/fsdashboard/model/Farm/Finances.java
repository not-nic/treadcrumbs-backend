package uk.notnic.fsdashboard.model.Farm;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Finances {
    @XmlElement(name = "stats")
    private ArrayList<FinanceStats> financeStatsList;

    public Finances() {
    }

    public Finances(ArrayList<FinanceStats> financeStatsList) {
        this.financeStatsList = financeStatsList;
    }

    public ArrayList<FinanceStats> getFinanceStatsList() {
        return financeStatsList;
    }

    public void setFinanceStatsList(ArrayList<FinanceStats> financeStatsList) {
        this.financeStatsList = financeStatsList;
    }
}
