package uk.notnic.fsdashboard.model.Placeables.Animals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "animal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Animal {

    @XmlAttribute(name = "subType")
    private String breed;

    @XmlAttribute(name = "numAnimals")
    private Integer numAnimal;

    @XmlAttribute(name = "age")
    private Integer age;

    @XmlAttribute(name = "health")
    private Integer health;

    @XmlAttribute(name = "reproduction")
    private Integer reproductionRate;

    public Animal() {
    }

    public Animal(String breed, Integer numAnimal, Integer age, Integer health, Integer reproductionRate) {
        this.breed = breed;
        this.numAnimal = numAnimal;
        this.age = age;
        this.health = health;
        this.reproductionRate = reproductionRate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getNumAnimal() {
        return numAnimal;
    }

    public void setNumAnimal(Integer numAnimal) {
        this.numAnimal = numAnimal;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getReproductionRate() {
        return reproductionRate;
    }

    public void setReproductionRate(Integer reproductionRate) {
        this.reproductionRate = reproductionRate;
    }
}
