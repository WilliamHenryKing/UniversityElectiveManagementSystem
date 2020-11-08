package za.ac.cput.elective.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Gender;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for GenderRepository
 * Date: 2020/08/30
 **/

@Repository
public interface GenderRepository extends JpaRepository<Gender, Character> {

}