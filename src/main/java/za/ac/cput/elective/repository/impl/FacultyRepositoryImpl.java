package za.ac.cput.elective.repository.impl;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create class for FacultyRepositoryImpl that implements FacultyRepository,
         containing the logic of the CRUD methods
 * Date: 30 August 2020
 **/

import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.repository.FacultyRepository;

import java.util.HashSet;
import java.util.Set;

public class FacultyRepositoryImpl implements FacultyRepository {

    private static FacultyRepository facuRep = null;
    private Set<Faculty> facuDB;

    private FacultyRepositoryImpl(){ this.facuDB = new HashSet<>();}

    public static FacultyRepository getRepository(){
        if (facuRep == null){
            facuRep = new FacultyRepositoryImpl();
        }

        return facuRep;
    }

    @Override
    public Faculty create(Faculty faculty) {
        this.facuDB.add(faculty);
        return faculty;
    }

    @Override
    public Faculty read(String id) {
        for (Faculty faculty : this.facuDB) {
            if (faculty.getFacultyID().equalsIgnoreCase(id))
                return faculty;

        }
        return null;
    }

    @Override
    public Faculty update(Faculty faculty) {
        boolean facuDel = delete(faculty.getFacultyID());
        if (facuDel){
            this.facuDB.add(faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Faculty facuDel = read(id);
        if (facuDel != null){
            this.facuDB.remove(facuDel);
            return true;
        }
        return false;
    }

    @Override
    public Set<Faculty> getAll() {
        return this.facuDB;
    }
}
