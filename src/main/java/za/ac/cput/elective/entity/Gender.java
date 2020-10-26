package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author @WilliamHenryKing
 * Desc: Entity for Gender
 * Date: 2020/07/05
 **/

@Entity
public class Gender {

    public enum genderIs {
        MALE, FEMALE, UNDEFINED
    }

    @Id
    private genderIs genderID;

    protected Gender() {}

    private Gender(Builder builder) {
        this.genderID = builder.genderID;
    }

    public char getGenderID() {
        switch (genderID) {
            case MALE:
                return 'M';
            case FEMALE:
                return 'F';
            case UNDEFINED:
                return 'U';
            default:
                return '0';
        }
    }

    public String getGenderDesc() {
        switch (genderID) {
            case MALE:
                return "Male";
            case FEMALE:
                return "Female";
            case UNDEFINED:
                return "Undefined";
            default:
                return "0";
        }
    }

    public static class Builder {
        private genderIs genderID;

        public Builder setGenderID(genderIs genderID) {
            this.genderID = genderID;
            return this;
        }

        public Builder copy(Gender gender) {
            this.genderID = gender.genderID;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }

    @Override
    public String toString() {
        return "\nGenderID: " + getGenderID() +
                "\nGender: '" + getGenderDesc() + "'";
    }

}