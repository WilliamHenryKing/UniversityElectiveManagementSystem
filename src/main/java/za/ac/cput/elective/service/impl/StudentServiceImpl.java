package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.repository.StudentRepository;
import za.ac.cput.elective.service.StudentService;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @Dogfoger / Sean Trainor 218060033
 * Desc: Interface for StudentService
 * Date: 5 September 2020
 **/

@Service
public class StudentServiceImpl implements StudentService {
    
    private static StudentService s = null;
    @Autowired
    private StudentRepository st;
/*
    private StudentServiceImpl() {
        this.st = StudentRepositoryImpl.getStudentRepository();
    }

    public static StudentService getStudentService() {
        if (s == null) {
            s = new StudentServiceImpl();
        }
        return s;
    }
*/
    @Override
    public Set<Student> getAll() {
        return this.st.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Student create(Student student) {

        return this.st.save(student);

    }

    @Override
    public Student read(String s) {
        return this.st.findById(s).orElseGet(null);
    }

    @Override
    public Student update(Student student) {
        if(this.st.existsById(student.getStudentID())) {
            return this.st.save(student);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.st.deleteById(s);
        if (this.st.existsById(s)) {
            return false;
        }
        else {
            return true;
        }

    }
}
