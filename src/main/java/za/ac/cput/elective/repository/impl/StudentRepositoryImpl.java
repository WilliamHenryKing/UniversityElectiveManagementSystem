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

        for (Student student : this.studentDB) {
            if (student.getStudentID().equalsIgnoreCase(s)) {
                return student;
            }

        }
        return null;
    }

    @Override
    public Student update (Student s) {
        boolean deleteStudent = delete(s.getStudentID());
        if (deleteStudent) {
            this.studentDB.add(s);
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
