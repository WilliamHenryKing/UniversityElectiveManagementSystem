package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Gender;

/**
 * @author @WilliamHenryKing
 * Desc: Test for Gender Factory
 * Date: 2020/07/05
 **/

public class GenderFactoryTest {

    @Test
    public void createGenderTest() {

        Gender.genderIs maleGender = Gender.genderIs.MALE;
        Gender gender = new GenderFactory().createGender(maleGender);

        Assert.assertEquals('M', gender.getGenderID());
        Assert.assertEquals("Male", gender.getGenderDesc());

    }
}