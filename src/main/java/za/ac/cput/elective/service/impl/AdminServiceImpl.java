package za.ac.cput.elective.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.repository.AdminRepository;
import za.ac.cput.elective.repository.impl.AdminRepositoryImpl;
import za.ac.cput.elective.service.AdminService;

import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {
    private static AdminService service = null;
    private AdminRepository repository;

    public AdminServiceImpl() {
        this.repository = AdminRepositoryImpl.getAdminRepository();
    }


    public static AdminService getService() {
        if (service == null) service = new AdminServiceImpl();
        return service;

    }

    @Override
    public Set<Admin> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Admin create(Admin race) {
        return this.create(race);
    }

    @Override
    public Admin read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Admin update(Admin race) {
        return this.repository.update(race);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }
}
