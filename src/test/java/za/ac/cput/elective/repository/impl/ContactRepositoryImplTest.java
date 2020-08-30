package za.ac.cput.elective.repository.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.factory.ContactFactory;
import za.ac.cput.elective.repository.ContactRepository;

/**
 * @author @WilliamHenryKing
 * Desc: Test for ContactRepository
 * Date: 2020/08/30
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {

    private static ContactRepository contactRepository = ContactRepositoryImpl.getContactRepository();
    private static Contact originalContact = ContactFactory.createContact("215028546@mycput.ac.za",
            "0123456789", "0987654321");

    @Test
    public void a_create() {
        Contact createdContact = contactRepository.create(originalContact);
        Assert.assertEquals(originalContact.getEmailAdd(), createdContact.getEmailAdd());
        System.out.println("\nCreated: " + createdContact);
    }

    @Test
    public void b_read() {
        Contact read = contactRepository.read(originalContact.getEmailAdd());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Contact updated = new Contact
                .Builder()
                .copy(originalContact)
                .setEmailAdd("266394587@mycput.ac.za")
                .build();

        updated = contactRepository.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = contactRepository.delete(originalContact.getEmailAdd());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        System.out.println("\nDisplay All: " + contactRepository.getAll());
    }
}