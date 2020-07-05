package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Student;

import java.util.UUID;

public class StudentFactory {

    public static Student createStudent(int year, String stream) {
        String studentID = UUID.randomUUID().toString();
        Student s = new Student.Builder()
                .setStream(studentID)
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
