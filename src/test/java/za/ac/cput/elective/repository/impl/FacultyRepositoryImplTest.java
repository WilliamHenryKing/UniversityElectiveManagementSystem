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
    private static Faculty facu = FacultyFactory.addFaculty("1234", "Engineering");

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

    }

    @Test
    public void e_delete() {

    }

    @Test
    public void d_getAll() {

    }
}