package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Admin;

import java.util.Set;

public interface AdminRepository extends IRepository<Admin,String>{
    Set<Admin> getAll();
}
