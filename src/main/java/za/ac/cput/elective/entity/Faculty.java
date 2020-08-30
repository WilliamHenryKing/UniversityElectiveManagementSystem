package za.ac.cput.elective.entity;

import java.util.*;

/**
 * @author: Ridhaa Hendricks, GitHub: ridhaahendricks
 * Desc: Created Faculty.java class with attributes using the Builder pattern
 * Date: 3rd July 2020
*/

public class Faculty {

    private String facultyID;
    private String facultyName;

    private Faculty(Builder builder) {
        this.facultyID = builder.facultyID;
        this.facultyName = builder.facultyName;
    }

    public static class Builder {

        private String facultyID;
        private String facultyName;

        public Builder() {
        }

        public Builder setFacultyID(String facultyID) {
            this.facultyID = facultyID;
            return this;
        }

        public Builder setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Builder copy(Faculty fac){
            this.facultyID = fac.facultyID;
            this.facultyName = fac.facultyName;
            return this;
        }

        public Faculty build() {return new Faculty(this);}
    }

    public String getFacultyID() {return facultyID;}

    public String getFacultyName() {return facultyName;}

    public void CheckRegStatus(long electCode) {
        /*
         * if electCode matches the room num then
         * assign student to room, else
         * change faculty and room
         */
    }

    @Override
    public String toString() {
        return "Faculty {" +
                "Faculty ID = " + facultyID +
                ", Faculty Name = '" + facultyName + '\'' +
                '}';
    }
}