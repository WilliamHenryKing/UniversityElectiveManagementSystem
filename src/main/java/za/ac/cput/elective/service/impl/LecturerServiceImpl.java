package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.repository.LecturerRepository;
//import za.ac.cput.elective.repository.impl.LecturerRepositoryImpl;
import za.ac.cput.elective.service.LecturerService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for LecturerService
 * Date: 2020/09/06
 **/
@Service
public class LecturerServiceImpl implements LecturerService {

    private static LecturerService lecturerService = null;


    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer read(Long l) {
        return this.lecturerRepository
                .findById(l)
                .orElseGet(null);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        if (this.lecturerRepository.existsById(lecturer.getLecturerID())) {
            return this.lecturerRepository.save(lecturer);
        }
        return null;
    }

    @Override
    public boolean delete(Long l) {
        this.lecturerRepository.deleteById(l);
        if (this.lecturerRepository.existsById(l)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.lecturerRepository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }

}
