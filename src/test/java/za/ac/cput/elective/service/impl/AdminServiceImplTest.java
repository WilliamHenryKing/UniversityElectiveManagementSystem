package za.ac.cput.elective.service.impl;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.factory.AdminFactory;
import za.ac.cput.elective.repository.AdminRepository;
import za.ac.cput.elective.repository.impl.AdminRepositoryImpl;
import za.ac.cput.elective.service.AdminService;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceImplTest {
    private static AdminService service = AdminServiceImpl.getService();
    private Admin admin = AdminFactory.buildAdmin("12","Ronnie");

    @Test
    public void a_create() {
        Admin ad = service.create(admin);
        assertEquals(ad.getAdminID(),admin.getAdminID());
    }

    @Test
    public void b_read() {

        Admin read = service.read(admin.getAdminID());
        System.out.println(read);
    }

    @Test
    public void c_update() {
        Admin update = new Admin.AdminBuilder().copy(admin).setAdminName("Ronald").build();
        System.out.println(service.update(update));
    }

    @Test
    public void e_delete() {
        service.delete(admin.getAdminID());
    }

    @Test
    public void d_getAll() {
       Set<Admin> ad = service.getAll();
       assertSame(ad,service.getAll());
        System.out.println(ad);
    }
}