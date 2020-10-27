package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.repository.ContactRepository;
//import za.ac.cput.elective.repository.impl.ContactRepositoryImpl;
import za.ac.cput.elective.service.ContactService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for ContactService
 * Date: 2020/09/04
 **/


@Service
public class ContactServiceImpl implements ContactService {

    private static ContactService contactService = null;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact read(String s) {
        return this.contactRepository
                .findById(s)
                .orElseGet(null);
    }

    @Override
    public Contact update(Contact contact) {
        if (this.contactRepository.existsById(contact.getEmailAdd())) {
            return this.contactRepository.save(contact);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.contactRepository.deleteById(s);
        if (this.contactRepository.existsById(s)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Contact> getAll() {
        return this.contactRepository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }

}
