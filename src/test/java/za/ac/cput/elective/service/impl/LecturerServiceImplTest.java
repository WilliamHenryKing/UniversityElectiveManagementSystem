package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.factory.LecturerFactory;
import za.ac.cput.elective.service.LecturerService;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author @WilliamHenryKing
 * Desc: Test for LecturerService
 * Date: 2020/09/06
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LecturerServiceImplTest {

    @Autowired
    private static LecturerService lecturerService;

    private static Gender maleGender = GenderFactory.createGender(Gender.genderIs.MALE);
    private static Lecturer originalLecturer = LecturerFactory.createLecturer(621548793
            , "Anikwue"
            , "Arinze"
            , maleGender);

    @Test
    public void a_create() {
        Lecturer createdLecturer = lecturerService.create(originalLecturer);
        Assert.assertEquals(originalLecturer.getLecturerID(), createdLecturer.getLecturerID());
        System.out.println("\nCreated: " + createdLecturer);
    }

    @Test
    public void b_read() {
        Lecturer read = lecturerService.read(originalLecturer.getLecturerID());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Lecturer updated = new Lecturer
                .Builder()
                .copy(originalLecturer)
                .setLecturerID(621548798) // corrected a single number
                .build();

        updated = lecturerService.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = lecturerService.delete(originalLecturer.getLecturerID());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        Set<Lecturer> lecturers = lecturerService.getAll();
        assertEquals(2, lecturers.size());
        System.out.println("\nDisplay All: " + lecturerService.getAll());
    }
}