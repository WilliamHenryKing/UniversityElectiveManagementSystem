package za.ac.cput.elective.factory;

/*
 * @author: Wasiem Cassiem , GitHub: Wasiem1908
 * Desc: Create MarkFactoryTest.java class. Tested and complete.
 * Date: 07 July 2020
 */

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Mark;

import static org.junit.Assert.*;

public class MarkFactoryTest
{

    @Test
    public void createMark()
    {
        Mark mark = MarkFactory.createMark("001");
        Assert.assertEquals("001", mark.getMarksID());
    }
}