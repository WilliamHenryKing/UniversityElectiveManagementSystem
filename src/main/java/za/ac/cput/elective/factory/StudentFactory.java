package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Student;

import java.util.Random;
import java.util.UUID;

public class StudentFactory {


    public static Student createStudent(int year, String stream) {
        Double studentID = Math.random() * (1000 - 1 +1) + 1;

        Student s = new Student.Builder()
                .setStudentID(studentID.toString())
                .setYear(year)
                .setStream(stream)
                .build();
        return s;
    }

    public static Student chooseElective() {
        return null;
    }

    public static Student cancelElective() {
        return null;
    }
}
