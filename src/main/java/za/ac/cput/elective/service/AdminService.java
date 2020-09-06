package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Admin;

import java.util.Set;

public interface AdminService extends IService<Admin,String>{
Set<Admin> getAll();
}
