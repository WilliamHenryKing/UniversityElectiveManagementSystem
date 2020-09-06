package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Contact;
import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for ContactService
 * Date: 2020/09/04
 **/

public interface ContactService extends IService<Contact, String> {
    Set<Contact> getAll();
}
