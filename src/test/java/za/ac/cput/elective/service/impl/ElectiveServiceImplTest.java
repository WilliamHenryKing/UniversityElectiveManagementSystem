package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.ContactFactory;
import za.ac.cput.elective.factory.ElectiveFactory;
import za.ac.cput.elective.factory.FacultyFactory;
import za.ac.cput.elective.service.ContactService;
import za.ac.cput.elective.service.ElectiveService;
import za.ac.cput.elective.service.FacultyService;

import java.util.Set;

import static org.junit.Assert.*;
/**
 * @author @ShanePhumlaniMapasie
 * Desc: Test for ElectiveServiceImpl
 * Date: 06/09/2020
 **/
public class ElectiveServiceImplTest {

    private static ElectiveService eService = ElectiveServiceImpl.getElectiveService();
    private static Elective elect = ElectiveFactory.createElective("Data Structures",
            "It involves Binary Trees, with Java integrated code");

    @Test
    public void a_create() {
        Elective created = eService.create(elect);
        Assert.assertEquals(elect.getElectName(), created.getElectName());
        System.out.println("CREATED: " + created);
    }

    @Test
    public void b_read() {
        Elective alert = eService.read(elect.getElectName());
        System.out.println("Elective Name: " + alert.getElectName() +
                ", Elective Desc: " + alert.getElectDesc());
    }

    @Test
    public void c_update() {
        Elective amend = new Elective.Builder()
                .copy(elect)
                .setElectName("Data Structures")
                .build();
        amend = eService.update(amend);
        System.out.println("\nAmended: " + amend);
    }

    @Test
    public void e_delete() {
        boolean erased = eService.delete(elect.getElectName());
        Assert.assertTrue(erased);
        if (erased = true ){
            System.out.println("Elective successfully deleted");
        } else {
            System.out.println("Elective deletion not successful");
        }
    }

    @Test
    public void d_getAll() {
        Set<Elective> electives = eService.getAll();
        Assert.assertEquals(1, electives.size());
        System.out.println("\nDisplay All:\n" + electives);
    }
}