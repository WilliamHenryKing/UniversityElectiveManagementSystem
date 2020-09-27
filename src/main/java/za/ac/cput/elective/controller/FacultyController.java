package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.FacultyFactory;
import za.ac.cput.elective.service.impl.FacultyServiceImpl;

import java.util.Set;

/**
 *  @author: Ridhaa Hendricks, GitHub: ridhaahendricks
 *  Desc: Spring Boot controller for Faculty to access the FacultyService method 'CRUD'
 *  Date: 21st September 2020
 */

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyServiceImpl facultyService;

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public Faculty create(@RequestBody Faculty faculty) {

        Faculty facu = FacultyFactory.addFaculty(faculty.getFacultyID(), faculty.getFacultyName());

        return facultyService.create(facu);
    }
    
    @RequestMapping(value = "/show/{name}", method = {RequestMethod.GET})
    public Faculty show(@PathVariable String name){
        return facultyService.read(name);
    }

    @RequestMapping(value = "/change/{id}/{name}", method = {RequestMethod.PATCH})
    public Faculty change(@PathVariable String id, @PathVariable String name, Faculty faculty){
        if (id.equalsIgnoreCase(faculty.getFacultyID()) && faculty.getFacultyName() != null){
            faculty = FacultyFactory.addFaculty(faculty.getFacultyID(), name);
        }

        return facultyService.update(faculty);
    }

    @RequestMapping(value = "/showAll", method = {RequestMethod.GET})
    public Set<Faculty> showAll(){
        return facultyService.getAll();
    }

    @RequestMapping(value = "/delete/{id}/{name}", method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable String id, @PathVariable String name, Faculty faculty){
        if (id.equalsIgnoreCase(faculty.getFacultyID()) && faculty.getFacultyName() != null){
            faculty = FacultyFactory.addFaculty(faculty.getFacultyID(), name);
        }

        return facultyService.delete(name);
    }

}
