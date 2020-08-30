package za.ac.cput.elective.repository.impl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.factory.AdminFactory;
import za.ac.cput.elective.repository.AdminRepository;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryImplTest {
    private static AdminRepository repo = new AdminRepositoryImpl();
    private Admin admin = AdminFactory.buildAdmin("01","Ron");

    @Test
    public void a_create() {
        Admin ad = repo.create(admin);
        assertEquals(ad.getAdminID(),admin.getAdminID());
    }

    @Test
    public void b_read() {
        Admin read = repo.read(admin.getAdminID());
    }

    @Test
    public void c_update() {
        Admin update = new Admin.AdminBuilder().copy(admin).setAdminName("Ronald").build();
        System.out.println(repo.update(update));
    }

    @Test
    public void e_delete() {
        repo.delete(admin.getAdminID());
    }

    @Test
    public void d_getAll() {
        System.out.println(repo.getAll());
    }
}