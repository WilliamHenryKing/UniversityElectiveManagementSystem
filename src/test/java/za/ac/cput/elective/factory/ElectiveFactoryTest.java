package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.entity.Student;

import static org.junit.Assert.*;

public class ElectiveFactoryTest {

    @Test
    public void createElective() {
        ElectiveFactory ef = new ElectiveFactory();

        Elective elec = ElectiveFactory.createElective(3665, "Business Analysis");
        Assert.assertEquals(3665, elec.getElectCode());
        Assert.assertEquals("Business Analysis", elec.getElectName());

    }
}