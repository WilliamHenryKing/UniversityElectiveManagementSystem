package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.FacultyFactory;
import za.ac.cput.elective.repository.FacultyRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyRepositoryImplTest {

    private static FacultyRepository facuRepo = FacultyRepositoryImpl.getRepository();
    private static Faculty facu = FacultyFactory.addFaculty("1234", "Engineeeering");

    @Test
    public void a_create() {
        Faculty added = facuRepo.create(facu);
        Assert.assertEquals(facu.getFacultyID(), added.getFacultyID());
        System.out.println("Added: " + added);
    }

    @Test
    public void b_read() {
        Faculty found = facuRepo.read(facu.getFacultyID());
        System.out.println(found.getFacultyID());
    }

    @Test
    public void c_update() {
        Faculty changed = new Faculty.Builder().copy(facu).setFacultyName("Engineering").build();
        changed = facuRepo.update(changed);
        System.out.println("Changed: " + changed);
    }

    @Test
    public void e_delete() {
        boolean removed = facuRepo.delete(facu.getFacultyID());
        Assert.assertTrue(removed);
    }
    
    @Test
    public void d_getAll() {
        System.out.println("Get All: " + facuRepo.getAll());
    }
}