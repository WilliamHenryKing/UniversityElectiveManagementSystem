package za.ac.cput.elective.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.factory.AdminFactory;
import za.ac.cput.elective.service.impl.AdminServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin) {

        Admin newAdmin = AdminFactory.buildAdmin(admin.getAdminID(),admin.getAdminName());
        return adminService.create(newAdmin);
    }

    @GetMapping("/read/{adminID}")
    public Admin read(@PathVariable String adminID) {
        return adminService.read(adminID);
    }

    @GetMapping("/update")
    public Admin update (@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @GetMapping("/delete/{adminID}")
    public boolean delete(@PathVariable String adminID) {
        return adminService.delete(adminID);
    }

    @GetMapping("/all")
    public Set<Admin> getAll() {
        return adminService.getAll();
    }

}
