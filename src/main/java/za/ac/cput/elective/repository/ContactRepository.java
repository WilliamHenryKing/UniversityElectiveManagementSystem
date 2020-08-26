package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Contact;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for ContactRepository
 * Date: 2020/08/26
 **/

public interface ContactRepository extends IRepository<Contact, String> {
    Set<Contact> getAll();
}
