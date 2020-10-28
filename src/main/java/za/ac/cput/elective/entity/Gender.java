package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author @WilliamHenryKing
 * Desc: Entity for Gender
 * Date: 2020/07/05
 **/

@Entity
public class Gender {

    @Id
    private char genderID;

    protected Gender() {}

    private Gender(Builder builder) {
        this.genderID = builder.genderID;

    }

    public char getGenderID() {
        return genderID;
    }

    public String getGenderDesc() {
        switch (genderID) {
            case 'M':
                return "Male";
            case 'F':
                return "Female";
            case 'U':
                return "Undefined";
            default:
                return "0";
        }
    }

    public static class Builder {
        private char genderID;

        public Builder setGenderID(char genderID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return genderID == gender.genderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genderID);
    }
}