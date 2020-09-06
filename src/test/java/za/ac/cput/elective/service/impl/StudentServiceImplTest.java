package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.factory.StudentFactory;
import za.ac.cput.elective.service.StudentService;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author @Dogfoger / Sean Trainor 218060033
 * Desc: Interface for StudentService
 * Date: 5 September 2020
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceImplTest {

    private static StudentService s = StudentServiceImpl.getStudentService();
    private static Student st = StudentFactory.createStudent(2, "MM");


    @Test
    public void d_getAll() {
        Set<Student> students = s.getAll();
        assertEquals(1, students.size());
        System.out.println("Students: " + students);
    }

    @Test
    public void a_create() {
        Student c = s.create(st);
        Assert.assertEquals(c.getStudentID(), st.getStudentID());
        System.out.println(c);
    }

    @Test
    public void b_read() {

        Student stu = s.create(st);
        Student stud = s.read(stu.getStudentID());
        System.out.println(stud);

    }

    @Test
    public void c_update() {
        Student u = new Student.Builder().copy(st).setStudentID("230").build();
        u = s.update(u);
        System.out.println(u);
    }

    @Test
    public void e_delete() {
        Student stu = s.create(st);
        boolean d = s.delete(st.getStudentID());
        Assert.assertTrue(d);
    }
}