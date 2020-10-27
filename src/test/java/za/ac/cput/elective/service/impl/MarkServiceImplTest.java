package za.ac.cput.elective.service.impl;

/**
 * @author @Wasiem Cassiem
 * Desc: This is a Class to test: MarkServiceImplTest.java
 * Date: 6 September 2020
 **/

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.factory.MarkFactory;
import za.ac.cput.elective.service.MarkService;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarkServiceImplTest
{
    @Autowired
    private static MarkService service;
    private static Mark mark = MarkFactory.createMark("aaa");

    @Test
    public void d_getAll()
    {
        Set<Mark> marks = service.getAll();
        assertEquals(1, marks.size());
        System.out.println("All Marks: " + marks);
    }

    @Test
    public void a_create()
    {
        Mark created = service.create(mark);
        Assert.assertEquals(mark.getMarksID(), created.getMarksID());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read()
    {
        Mark read = service.read(mark.getMarksID());
        System.out.println("Read " + read);
    }

    @Test
    public void c_update()
    {
        Mark updated = new Mark.Builder().copy(mark).setMarksID("001").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete()
    {
        boolean deleted = service.delete(mark.getMarksID());
        Assert.assertTrue(deleted);
    }
}