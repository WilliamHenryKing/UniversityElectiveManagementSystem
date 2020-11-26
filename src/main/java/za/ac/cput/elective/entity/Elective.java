package za.ac.cput.elective.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * @author: Shane  Mapasie, GitHub: SPMapasie216182425
 * Desc: Create Elective.java class with attributes using the Builder pattern
 * Date: 4rd July 2020
 */


@Entity
public class Elective  {

    /* Encapsulation */
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Id// adding the
    private String electCode;
    private String electName;

    /*No argument constructor, protected*/
    protected Elective(){}

    /* constructor */
    public Elective(Builder builder) {
        this.electName = builder.electName;
        this.electCode = builder.electCode;

    }

    //getters
    public String getElectName() {
        return electName;
    }

    public String getElectCode() {
        return electCode;
    }


    //toString Method
    @Override
    public String toString() {
        return "Elective{" +
                "Elective Name=" + electName +
                ", Elective Code=" + electCode + '\'' +
                '}';
    }

    public static class Builder {

        private String electName;
        private String electCode;

        /* setters using builder */
        public Builder setElectName(String electName) {
            this.electName = electName;
            return this;
        }

        public Builder setElectCode(String electCode) {
            this.electCode = electCode;
            return this;
        }

        /*Constructor with Builder Implemented*/
        public Builder copy(Elective elect) {
            this.electName = elect.electName;
            this.electCode = elect.electCode;
            return this;
        }

        /*Methods*/
        public Elective build() {
            return new Elective(this);
        }

    }
}


