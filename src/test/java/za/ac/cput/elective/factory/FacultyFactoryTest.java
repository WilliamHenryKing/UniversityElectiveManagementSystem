package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Faculty;

import static org.junit.Assert.*;

/*
 * @author: Ridhaa Hendricks, GitHub: ridhaahendricks
 * Desc: Created FacultyFacultyTest.java added values for testing purposes.
 * Date: 3rd July 2020
 */

public class FacultyFactoryTest {

    @Test
    public void testAddFaculty() {

        Faculty facu = new FacultyFactory().addFaculty(1234, "Engineering");

        Assert.assertTrue(facu.getFacultyID() < 9999);
        Assert.assertNotNull("Faculty cannot be Empty", facu.getFacultyName());
    }
}