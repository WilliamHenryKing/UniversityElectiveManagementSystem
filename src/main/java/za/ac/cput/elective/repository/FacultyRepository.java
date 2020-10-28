package za.ac.cput.elective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Faculty;


/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create Interface for FacultyRepository from Repository
 * Date: 27th August 2020
 **/

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String>{

}
