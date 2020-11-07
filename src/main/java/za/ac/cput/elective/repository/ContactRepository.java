package za.ac.cput.elective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Contact;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for ContactRepository
 * Date: 2020/08/26
 **/
@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {

}
