package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Contact;

import static org.junit.Assert.*;

/**
 * @author @WilliamHenryKing
 * Desc: Test for Contact Factory
 * Date: 2020/07/05
 **/

public class ContactFactoryTest {

    @Test
    public void createContactTest() {

        Contact contact = new ContactFactory().createContact("215028546@mycput.ac.za",
                "0123456789", "0987654321");

        Assert.assertTrue(contact.getEmailAdd().contains("@"));
        Assert.assertTrue(contact.getCellNo().matches("[0]{1}[0-9]{9}"));
        Assert.assertTrue(contact.getTelNo().matches("[0]{1}[0-9]{9}"));

        Assert.assertEquals("215028546@mycput.ac.za", contact.getEmailAdd());
        Assert.assertEquals("0123456789", contact.getCellNo());
        Assert.assertEquals("0987654321", contact.getTelNo());

    }
}