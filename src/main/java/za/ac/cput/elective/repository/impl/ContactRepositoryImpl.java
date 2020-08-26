package za.ac.cput.elective.repository.impl;

import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.repository.ContactRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for ContactRepository
 * Date: 2020/08/26
 **/

public class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepository contactRepository = null;
    private Set<Contact> contactSet;

    private ContactRepositoryImpl() {

        this.contactSet = new HashSet<>();

    }

    public static ContactRepository getContactRepository() {

        Optional.ofNullable(contactRepository)
                .ifPresentOrElse(x -> {
                }, (Runnable) (contactRepository = new ContactRepositoryImpl()));

        return contactRepository;

    }

    @Override
    public Contact create(Contact contact) {
        this.contactSet.add(contact);
        return contact;
    }

    @Override
    public Contact read(String s) {
        Contact contact = this.contactSet
                .stream()
                .filter(x -> x.getEmailAdd()
                        .trim()
                        .equalsIgnoreCase(s))
                .findAny()
                .orElse(null);

        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        if (!delete(contact.getEmailAdd())) {
            this.contactSet.add(contact);
            return contact;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Contact contact = read(s);
        if (contact != null) {
            this.contactSet.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Set<Contact> getAll() {
        return this.contactSet;
    }

}
