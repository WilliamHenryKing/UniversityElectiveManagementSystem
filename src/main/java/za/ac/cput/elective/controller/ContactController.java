package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.factory.ContactFactory;
import za.ac.cput.elective.service.impl.ContactServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact) {

        Contact contact2 = ContactFactory.createContact(
                contact.getEmailAdd(),
                contact.getCellNo(),
                contact.getTelNo());

        return contactService.create(contact2);

    }

    @GetMapping("/read/{emailID}")
    public Contact read(@PathVariable String emailID) {
        return contactService.read(emailID);
    }

    @GetMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        return contactService.update(contact);
    }

    @GetMapping("/all")
    public Set<Contact> getAll() {
        return contactService.getAll();
    }

    @DeleteMapping("/delete/{emailID}")
    public boolean delete(@PathVariable String emailID) {
        return contactService.delete(emailID);
    }

}
