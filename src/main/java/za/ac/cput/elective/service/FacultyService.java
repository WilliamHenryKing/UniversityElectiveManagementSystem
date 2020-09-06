package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Faculty;

import java.util.Set;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create Interface for FacultyService from IService
 * Date: 6th September 2020
 **/

public interface FacultyService extends IService<Faculty, String> {
    Set<Faculty> getAll();

    // all unique business logic goes beneath:

}
