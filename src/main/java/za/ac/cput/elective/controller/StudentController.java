package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.factory.StudentFactory;
import za.ac.cput.elective.service.impl.StudentServiceImpl;

import java.io.Serializable;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student s) {

        Student student = StudentFactory.createStudent(s.getYear(), s.getStream());

        return studentService.create(s);
    }

    @GetMapping("/read/{studentID}")
    public Student read(@PathVariable String studentID) {
        return studentService.read(studentID);
    }

    @GetMapping("/update")
    public Student update (@RequestBody Student s) {
        return studentService.update(s);
    }

    @GetMapping("/delete/{studentID}")
    public boolean delete(@PathVariable String studentID) {
        return studentService.delete(studentID);
    }

    @GetMapping("/all")
    public Set<Student> getAll() {
        return studentService.getAll();
    }


}
