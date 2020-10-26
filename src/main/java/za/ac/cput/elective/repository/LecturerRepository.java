package za.ac.cput.elective.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Lecturer;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for LecturerRepository
 * Date: 2020/08/30
 **/
@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

}
