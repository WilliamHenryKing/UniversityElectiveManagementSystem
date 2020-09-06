package za.ac.cput.elective.service.impl;

import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.repository.FacultyRepository;
import za.ac.cput.elective.repository.impl.FacultyRepositoryImpl;
import za.ac.cput.elective.service.FacultyService;

import java.util.Set;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create FacultyServiceImpl which extends FacultyService
 * Date: 6th September 2020
 **/

public class FacultyServiceImpl implements FacultyService {

    private static FacultyService facuServ = null;
    private FacultyRepository facuRep;

    private FacultyServiceImpl(){
        this.facuRep = FacultyRepositoryImpl.getRepository();
    }

    public static FacultyService getService(){
        if (facuServ == null){
            facuServ = new FacultyServiceImpl();
        }

        return facuServ;
    }

    @Override
    public Faculty create(Faculty faculty) {
        return this.facuRep.create(faculty);
    }

    @Override
    public Faculty read(String s) {
        return this.facuRep.read(s);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return this.facuRep.update(faculty);
    }

    @Override
    public boolean delete(String s) {
        return this.facuRep.delete(s);
    }

    @Override
    public Set<Faculty> getAll() {
        return this.facuRep.getAll();
    }

}
