package uk.notnic.fsdashboard.model.Items;

import javax.persistence.*;

@Entity
@Table(name = "bale")
@SequenceGenerator(name = "bale_seq", allocationSize = 1)
public class Bale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bale_seq")
    private Long id;

    private Integer baleCount;

    private String fillType;

    private Double totalCount;

    public Bale() {
    }

    public Bale(Long id, Integer baleCount, String fillType, Double totalCount) {
        this.id = id;
        this.baleCount = baleCount;
        this.fillType = fillType;
        this.totalCount = totalCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBaleCount() {
        return baleCount;
    }

    public void setBaleCount(Integer baleCount) {
        this.baleCount = baleCount;
    }

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public Double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Double totalCount) {
        this.totalCount = totalCount;
    }
}
