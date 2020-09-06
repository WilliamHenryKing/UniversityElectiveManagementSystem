package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Student;

import java.util.Set;

/**
 * @author @Dogfoger / Sean Trainor 218060033
 * Desc: Interface for StudentService
 * Date: 5 September 2020
 **/

public interface StudentService extends IService<Student, String> {
    Set<Student> getAll();
}
