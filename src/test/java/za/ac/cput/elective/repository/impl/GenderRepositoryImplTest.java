package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.repository.GenderRepository;

import javax.swing.*;

/**
 * @author @WilliamHenryKing
 * Desc: Test for GenderRepository
 * Date: 2020/08/30
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderRepositoryImplTest {

    private static GenderRepository genderRepository = GenderRepositoryImpl.getGenderRepository();
    private static Gender.genderIs femaleGender = Gender.genderIs.FEMALE;
    private static Gender originalGender = new GenderFactory().createGender(femaleGender);

    @Test
    public void a_create() {
        Gender createdGender = genderRepository.create(originalGender);
        Assert.assertEquals(originalGender.getGenderID(), createdGender.getGenderID());
        System.out.println("\nCreated: " + createdGender);
    }

    @Test
    public void b_read() {
        Gender read = genderRepository.read(originalGender.getGenderID());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Gender updated = new Gender
                .Builder()
                .copy(originalGender)
                .setGenderID(Gender.genderIs.UNDEFINED) // changed from female to undefined
                .build();

        updated = genderRepository.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = genderRepository.delete(originalGender.getGenderID());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        System.out.println("\nDisplay All: " + genderRepository.getAll());
    }
}