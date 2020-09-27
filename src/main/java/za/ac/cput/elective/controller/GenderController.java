package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Contact;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.service.impl.GenderServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderServiceImpl genderService;

    @PostMapping("/create")
    public Gender create(@RequestBody Gender gender) {

        Gender gender2 = GenderFactory.createGender(Gender.genderIs.valueOf(gender.getGenderDesc()));

        return genderService.create(gender2);

    }

    @GetMapping("/read/{genderID}")
    public Gender read(@PathVariable char genderID) {
        return genderService.read(genderID);
    }

    @GetMapping("/update")
    public Gender update(@RequestBody Gender gender) {
        return genderService.update(gender);
    }

    @GetMapping("/all")
    public Set<Gender> getAll() {
        return genderService.getAll();
    }

    @DeleteMapping("/delete/{genderID}")
    public boolean delete(@PathVariable char genderID) {
        return genderService.delete(genderID);
    }

}