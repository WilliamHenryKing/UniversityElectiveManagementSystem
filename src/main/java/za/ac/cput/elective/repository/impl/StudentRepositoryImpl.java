package za.ac.cput.elective.repository.impl;

import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.repository.StudentRepository;
import java.util.HashSet;
import java.util.Set;

/**
 * @author @Dogfoger/SeanTrainor
 * Desc: Implementation for StudentRepository
 * Date: 2020/08/26
 **/

public class StudentRepositoryImpl implements StudentRepository {

    private static StudentRepository studentRepository = null;
    private Set<Student> studentDB;

    StudentRepositoryImpl() {

        this.studentDB = new HashSet<>();

    }

    public static StudentRepository getStudentRepository() {

        if (studentRepository == null) {
            studentRepository = new StudentRepositoryImpl();
        }
        return studentRepository;

    }

    @Override
    public Student create(Student s) {
        this.studentDB.add(s);
        return s;
    }

    @Override
    public Student read (String s) {

        Student student = this.studentDB.stream().filter(x -> x.getStudentID().trim().equalsIgnoreCase(s)).findAny().orElse(null);
        return student;

    }

    @Override
    public Student update (Student s) {
        if(!delete(s.getStudentID())) {
            this.studentDB.add(s);
            return s;
        }

        return null;
    }

    @Override
    public boolean delete (String s) {
        Student st = read(s);

        if (st != null) {
            this.studentDB.remove(st);
            return true;
        }

        else {
            return false;
        }

    }

    @Override
    public Set<Student> getAll() {

        return this.studentDB;
    }
}
