package za.ac.cput.elective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.elective.entity.Admin;

import java.util.Set;

public interface AdminRepository extends JpaRepository<Admin,String> {

}
