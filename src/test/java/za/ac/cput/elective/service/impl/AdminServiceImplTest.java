package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.factory.AdminFactory;
import za.ac.cput.elective.repository.AdminRepository;
import za.ac.cput.elective.service.AdminService;


import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceImplTest {
    @Autowired
    private static AdminService service;
    private AdminRepository repository;
    private static Admin adminNew = AdminFactory.buildAdmin("007","Ron");


    @Test
    public void a_create() {
        Admin newAd = service.create(adminNew);
        Assert.assertEquals(newAd.getAdminID(), adminNew.getAdminID());
        }

    @Test
    public void b_read() {
        Admin get = service.read(adminNew.getAdminID());
        Assert.assertNotNull(get);
    }

    @Test
    public void c_update() {
        Admin edit = new Admin.AdminBuilder().copy(adminNew).setAdminName("Ronny").build();
        Assert.assertEquals(edit.getAdminName(),"Ronny");
    }

    @Test
    public void delete() {
    String id = adminNew.getAdminID();
        this.repository.deleteById(id);

    }


    @Test
    public void d_getAll() {
        Set<Admin> admins = service.getAll();
        assertNotNull(admins);
    }
}