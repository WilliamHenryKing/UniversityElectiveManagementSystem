package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.factory.StudentFactory;
import za.ac.cput.elective.repository.StudentRepository;

import java.util.UUID;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {

    StudentRepository s = new StudentRepositoryImpl();
    Student st = StudentFactory.createStudent(3, "AppDev");

    @Test
    public void create() {
        Student stu = s.create(st);

        assertEquals("AppDev" + st.getStudentID() + 3, stu.getStream() + stu.getStudentID() + stu.getYear());

    }

    @Test
    public void read() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void getAll() {
    }
}