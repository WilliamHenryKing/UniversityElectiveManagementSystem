package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Contact;

import java.util.Set;

public interface ContactRepository extends IRepository<Contact, String> {
    Set<Contact> getAll();
}
