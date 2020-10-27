package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.service.GenderService;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author @WilliamHenryKing
 * Desc: Test for GenderServiceImpl
 * Date: 2020/09/06
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceImplTest {

    @Autowired
    private static GenderService genderService;

    private static Gender.genderIs femaleGender = Gender.genderIs.FEMALE;
    private static Gender originalGender = new GenderFactory().createGender(femaleGender);

    @Test
    public void a_create() {
        Gender createdGender = genderService.create(originalGender);
        Assert.assertEquals(originalGender.getGenderID(), createdGender.getGenderID());
        System.out.println("\nCreated: " + createdGender);
    }

    @Test
    public void b_read() {
        Gender read = genderService.read(originalGender.getGenderID());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Gender updated = new Gender
                .Builder()
                .copy(originalGender)
                .setGenderID(Gender.genderIs.UNDEFINED) // changed from female to undefined
                .build();

        updated = genderService.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = genderService.delete(originalGender.getGenderID());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        Set<Gender> genders = genderService.getAll();
        assertEquals(2, genders.size());
        System.out.println("\nDisplay All: " + genderService.getAll());
    }
}