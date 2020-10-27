package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.repository.FacultyRepository;
import za.ac.cput.elective.service.FacultyService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
 * Desc: Create FacultyServiceImpl which extends FacultyService
 * Date: 6th September 2020
 **/

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facuRep;

    @Override
    public Faculty create(Faculty faculty) {
        return this.facuRep.save(faculty);
    }

    @Override
    public Faculty read(String s) {return this.facuRep.findById(s).orElseGet(null); }

    @Override
    public Faculty update(Faculty faculty) {
        if(this.facuRep.existsById(faculty.getFacultyID())) {
            return this.facuRep.save(faculty);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
         this.facuRep.deleteById(s);
         if (this.facuRep.existsById(s)){
             return false;
         } else {
             return true;
         }
    }

    @Override
    public Set<Faculty> getAll() {
        return this.facuRep.findAll().stream().collect(Collectors.toSet());
    }
}
