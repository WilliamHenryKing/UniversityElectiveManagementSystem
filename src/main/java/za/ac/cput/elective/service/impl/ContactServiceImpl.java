package za.ac.cput.elective.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.repository.ContactRepository;
import za.ac.cput.elective.repository.impl.ContactRepositoryImpl;
import za.ac.cput.elective.service.ContactService;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for ContactService
 * Date: 2020/09/04
 **/


@Service
public class ContactServiceImpl implements ContactService {

    private static ContactService contactService = null;
    private ContactRepository contactRepository;

    private ContactServiceImpl() {
        this.contactRepository = ContactRepositoryImpl.getContactRepository();
    }

    public static ContactService getContactService() {
        if (contactService == null) {
            contactService = new ContactServiceImpl();
        }

        return contactService;
    }

    @Override
    public Contact create(Contact contact) {
        return this.contactRepository.create(contact);
    }

    @Override
    public Contact read(String s) {
        return this.contactRepository.read(s);
    }

    @Override
    public Contact update(Contact contact) {
        return this.contactRepository.update(contact);
    }

    @Override
    public boolean delete(String s) {
        return this.contactRepository.delete(s);
    }

    @Override
    public Set<Contact> getAll() {
        return this.contactRepository.getAll();
    }

}
