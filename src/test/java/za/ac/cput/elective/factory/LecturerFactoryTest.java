package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.entity.Lecturer;

/**
 * @author @WilliamHenryKing
 * Desc: Test for Lecturer Factory
 * Date: 2020/07/05
 **/

public class LecturerFactoryTest {

    @Test
    public void createLecturerTest() {

        Gender maleGender = GenderFactory.createGender(Gender.genderIs.MALE);

        Lecturer lecturer = LecturerFactory.createLecturer(621548793
                , "Anikwue"
                , "Arinze"
                , maleGender);

        Assert.assertTrue(String.valueOf(lecturer.getLecturerID()).matches("[0-9]{9}"));
        Assert.assertEquals(621548793, lecturer.getLecturerID());

        Assert.assertEquals("Anikwue", lecturer.getLecturerLName());
        Assert.assertEquals("Arinze", lecturer.getLecturerFName());
        Assert.assertEquals(maleGender, lecturer.getGender());
        Assert.assertEquals('M', lecturer.getGender().getGenderID());
        Assert.assertEquals("Male", lecturer.getGender().getGenderDesc());

    }
}