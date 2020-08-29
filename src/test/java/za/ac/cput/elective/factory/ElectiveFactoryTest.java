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

        Elective elec = ef.createElective("PHP", "Similar to Java, Just done in a HTML environment");
        Assert.assertEquals("PHP", elec.getElectName());
       Assert.assertEquals("Similar to Java, Just done in a HTML environment", elec.getElectDesc());
    }

}