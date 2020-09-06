package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.FacultyFactory;
import za.ac.cput.elective.service.FacultyService;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create test class for FacultyServiceImpl which will test all methods in
            FacultyServiceImpl
 * Date: 6th September 2020
 **/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyServiceImplTest {

    private static FacultyService facuServ = FacultyServiceImpl.getService();
    private static Faculty facu = FacultyFactory.addFaculty("1234", "Engeeeering");

    @Test
    public void a_create() {
        Faculty added = facuServ.create(facu);
        Assert.assertEquals(facu.getFacultyID(), added.getFacultyID());
        System.out.println("Added: " + added);
    }

    @Test
    public void b_read() {
        Faculty found = facuServ.read(facu.getFacultyID());
        System.out.println("Faculty ID: " + found.getFacultyID() + ", Faculty Name: " + found.getFacultyName());
    }

    @Test
    public void c_update() {
        Faculty changed = new Faculty.Builder().copy(facu).setFacultyName("Engineering").build();
        changed = facuServ.update(changed);
        System.out.println("Changed: " + changed);
    }

    @Test
    public void e_delete() {
        boolean removed = facuServ.delete(facu.getFacultyID());
        Assert.assertTrue(removed);
        if (removed = true ){
            System.out.println("Removed? Yes");
        } else {
            System.out.println("Removed? No");
        }
    }

    @Test
    public void d_getAll() {
        Set<Faculty> setOfFaculty = facuServ.getAll();
        Assert.assertEquals(1, setOfFaculty.size());
        System.out.println("All Faculties: " + setOfFaculty);
    }
}