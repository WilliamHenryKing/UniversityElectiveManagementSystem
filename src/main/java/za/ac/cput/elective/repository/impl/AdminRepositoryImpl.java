package za.ac.cput.elective.repository.impl;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.repository.AdminRepository;


import java.util.HashSet;
import java.util.Set;


public class AdminRepositoryImpl implements AdminRepository {
    private Set<Admin> adminDB;

    public AdminRepositoryImpl() {
        this.adminDB = new HashSet<>();
    }

    // Create Admin
    @Override
    public Admin create(Admin admin) {
        this.adminDB.add(admin);
        return admin;
    }

    //Read admin
    @Override
    public Admin read(String adminID) {
        Admin admin = null;
        for(Admin ad: this.adminDB) {

            if(ad.getAdminName().equalsIgnoreCase(adminID)){
                admin = ad;
                break;
            }
        }
        return admin;
    }

    //Update Admin
    @Override
    public Admin update(Admin admin) {
        Admin oldAdmin = read(admin.getAdminID());
        if(oldAdmin != null){
            this.adminDB.remove(oldAdmin);
            this.adminDB.add(admin);
        }
        return admin;
    }

    //delete Admin
    @Override
    public boolean delete(String adminID) {
        Admin admin = read(adminID);
        if(admin != null) this.adminDB.remove(admin);

        return false;
    }

   //get all method
    @Override
    public Set<Admin> getAll() {
        return this.adminDB;
    }
}
