package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Faculty;

import java.util.Set;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create Interface for FacultyRepository from Repository
 * Date: 27th August 2020
 **/

public interface FacultyRepository extends IRepository<Faculty, String>{
    Set<Faculty> getAll();
}
