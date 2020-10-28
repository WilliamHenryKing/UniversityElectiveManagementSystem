package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.repository.AdminRepository;
import za.ac.cput.elective.service.AdminService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    
    @Autowired
    private AdminRepository repository;


    @Override
    public Set<Admin> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Admin create(Admin admin) {
        return this.create(admin);
    }

    @Override
    public Admin read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        
        if(this.repository.existsById(admin.getAdminID())){
            return this.repository.save(admin);
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
               
        this.repository.deleteById(id);
        if(this.repository.existsById(id)){
            return false;
        }
        return true;

    }
}
