package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.factory.StudentFactory;
import za.ac.cput.elective.repository.StudentRepository;

import java.util.UUID;

import static org.junit.Assert.*;

public class StudentRepositoryImplTest {

    private static StudentRepository s = new StudentRepositoryImpl().getStudentRepository();
    private static Student st = new StudentFactory().createStudent(3, "AppDev");


    @Test
    public void create() {
        Student stu = s.create(st);
        Assert.assertEquals(st.getStudentID(), stu.getStudentID());
        Assert.assertEquals(st.getStream(), stu.getStream());
        Assert.assertEquals(st.getYear(), stu.getYear());
    }

    @Test
    public void read() {
        Student stu = s.create(st);
        Student stud = s.read(stu.getStudentID());
        System.out.println(stud);
    }

    @Test
    public void update() {
        Student stu = s.create(st);
        Student u = new Student.Builder().copy(st).setStream("MM").build();

        u = s.update(u);

        System.out.println(u);

    }

    @Test
    public void delete() {
        Student stu = s.create(st);
        boolean d = s.delete(st.getStudentID());
        Assert.assertTrue(d);

    }

    @Test
    public void getAll() {
        Student stu = s.create(st);
        System.out.println(s.getAll());
    }
}