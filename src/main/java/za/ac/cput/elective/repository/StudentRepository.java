package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Student;

import java.util.Set;

public interface StudentRepository extends IRepository<Student, String>{
    Set<Student> getAll();
}
