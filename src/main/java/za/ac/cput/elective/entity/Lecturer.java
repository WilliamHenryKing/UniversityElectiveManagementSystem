package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author @WilliamHenryKing
 * Desc: Entity for Lecturer
 * Date: 2020/07/05
 **/

@Entity
public class Lecturer {

    @Id
    private Long lecturerID;

    private String lecturerLName;
    private String lecturerFName;
    private char genderID;

    protected Lecturer() {}

    private Lecturer(Builder builder) {
        this.lecturerID = builder.lecturerID;
        this.lecturerLName = builder.lecturerLName;
        this.lecturerFName = builder.lecturerFName;
        this.genderID = builder.genderID;
    }

    public Long getLecturerID() {
        return lecturerID;
    }

    public String getLecturerLName() {
        return lecturerLName;
    }

    public String getLecturerFName() {
        return lecturerFName;
    }

    public char getGenderID() {
        return genderID;
    }

    public static class Builder {
        private Long lecturerID;
        private String lecturerLName;
        private String lecturerFName;
        private char genderID;

        public Builder setLecturerID(long lecturerID) {
            this.lecturerID = lecturerID;
            return this;
        }

        public Builder setLecturerLName(String lecturerLName) {
            this.lecturerLName = lecturerLName;
            return this;
        }

        public Builder setLecturerFName(String lecturerFName) {
            this.lecturerFName = lecturerFName;
            return this;
        }

        public Builder setGender(char genderID) {
            this.genderID = genderID;
            return this;
        }

        public Builder copy(Lecturer lecturer) {
            this.lecturerID = lecturer.lecturerID;
            this.lecturerLName = lecturer.lecturerLName;
            this.lecturerFName = lecturer.lecturerFName;
            this.genderID = lecturer.genderID;
            return this;
        }

        public Lecturer build() {
            return new Lecturer(this);
        }
    }

    @Override
    public String toString() {
        return "Lecturer" +
                "\nLecturerID: " + lecturerID +
                "\nLecturerLName: " + lecturerLName +
                "\nLecturerFName: " + lecturerFName
                + "\nGender: " + genderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturer lecturer = (Lecturer) o;
        return lecturerID == lecturer.lecturerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturerID);
    }
}