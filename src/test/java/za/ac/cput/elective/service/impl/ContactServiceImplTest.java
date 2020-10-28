package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.factory.ContactFactory;
import za.ac.cput.elective.service.ContactService;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author @WilliamHenryKing
 * Desc: Test for ContactServiceImpl
 * Date: 2020/09/04
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {

    @Autowired
    private static ContactService contactService;

    private static Contact originalContact = ContactFactory.createContact("215028546@mycput.ac.za",
            "0123456789", "0987654321");

    @Test
    public void a_create() {
        Contact createdContact = contactService.create(originalContact);
        Assert.assertEquals(originalContact.getEmailAdd(), createdContact.getEmailAdd());
        System.out.println("\nCreated: " + createdContact);
    }

    @Test
    public void b_read() {
        Contact read = contactService.read(originalContact.getEmailAdd());
        System.out.println("\nTo String:\n" + read.toString());
    }

    @Test
    public void c_update() {
        Contact updated = new Contact
                .Builder()
                .copy(originalContact)
                .setEmailAdd("266394587@mycput.ac.za")
                .build();

        updated = contactService.update(updated);
        System.out.println("\nUpdated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleteSuccessful = contactService.delete(originalContact.getEmailAdd());
        Assert.assertTrue(deleteSuccessful);
    }

    @Test
    public void d_getAll() {
        Set<Contact> contacts = contactService.getAll();
        assertEquals(2, contacts.size());
        System.out.println("\nDisplay All:\n" + contacts);
    }
}