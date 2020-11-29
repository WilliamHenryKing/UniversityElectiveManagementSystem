package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Elective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Interface for ElectiveRepository
 * Date: 26/08/2020
 **/

@Repository
public interface ElectiveRepository extends JpaRepository<Elective, String> {

}
