package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Contact;

/**
 * @author @WilliamHenryKing
 * Desc: Factory for Contact
 * Date: 2020/07/05
 **/

public class ContactFactory {

    public static Contact createContact(String emailAdd, String cellNo, String telNo) {

        return new Contact.Builder()
                .setEmailAdd(emailAdd)
                .setCellNo(cellNo)
                .setTelNo(telNo)
                .build();
    }

}
