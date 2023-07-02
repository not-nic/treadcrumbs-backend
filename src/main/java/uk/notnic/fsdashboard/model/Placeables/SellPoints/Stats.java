package uk.notnic.fsdashboard.model.Placeables.SellPoints;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
@Embeddable
public class Stats implements Serializable {

    @XmlAttribute(name = "received")
    private Double goodsReceived;

    @XmlAttribute(name = "fillType")
    private String fillType;

    public Stats() {
    }

    public Stats(Double goodsReceived, String fillType) {
        this.goodsReceived = goodsReceived;
        this.fillType = fillType;
    }

    public Double getGoodsReceived() {
        return goodsReceived;
    }

    public void setGoodsReceived(Double goodsReceived) {
        this.goodsReceived = goodsReceived;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }
}
