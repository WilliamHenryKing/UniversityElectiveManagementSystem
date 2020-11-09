package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.factory.LecturerFactory;
import za.ac.cput.elective.service.impl.LecturerServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    private LecturerServiceImpl lecturerService;

    @PostMapping("/create")
    public Lecturer create(@RequestBody Lecturer lecturer) {

        Lecturer lecturer2 = LecturerFactory.createLecturer(lecturer.getLecturerID(),
                lecturer.getLecturerLName(),
                lecturer.getLecturerFName(),
                lecturer.getGenderID());

        return lecturerService.create(lecturer2);

    }

    @GetMapping("/read/{lecturerID}")
    public Lecturer read(@PathVariable Long lecturerID) {
        return lecturerService.read(lecturerID);
    }

    @GetMapping("/update")
    public Lecturer update(@RequestBody Lecturer lecturer) {
        return lecturerService.update(lecturer);
    }

    @GetMapping("/all")
    public Set<Lecturer> getAll() {
        return lecturerService.getAll();
    }

    @DeleteMapping("/delete/{lecturerID}")
    public boolean delete(@PathVariable Long lecturerID) {
        return lecturerService.delete(lecturerID);
    }

}