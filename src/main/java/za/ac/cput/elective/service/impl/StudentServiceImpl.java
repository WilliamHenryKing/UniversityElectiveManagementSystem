package za.ac.cput.elective.service.impl;

import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.repository.StudentRepository;
import za.ac.cput.elective.repository.impl.StudentRepositoryImpl;
import za.ac.cput.elective.service.StudentService;
import java.util.Set;

/**
 * @author @Dogfoger / Sean Trainor 218060033
 * Desc: Interface for StudentService
 * Date: 5 September 2020
 **/
public class StudentServiceImpl implements StudentService {
    
    private static StudentService s = null;
    private StudentRepository st;

    private StudentServiceImpl() {
        this.st = StudentRepositoryImpl.getStudentRepository();
    }

    public static StudentService getStudentService() {
        if (s == null) {
            s = new StudentServiceImpl();
        }
        return s;
    }

    @Override
    public Set<Student> getAll() {
        return this.st.getAll();
    }

    @Override
    public Student create(Student student) {

        return this.st.create(student);

    }

    @Override
    public Student read(String s) {
        return this.st.read(s);
    }

    @Override
    public Student update(Student student) {
        return this.st.update(student);
    }

    @Override
    public boolean delete(String s) {
        return this.st.delete(s);
    }
}
