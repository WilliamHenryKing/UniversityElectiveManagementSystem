package za.ac.cput.elective.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.repository.LecturerRepository;
import za.ac.cput.elective.repository.impl.LecturerRepositoryImpl;
import za.ac.cput.elective.service.LecturerService;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for LecturerService
 * Date: 2020/09/06
 **/
@Service
public class LecturerServiceImpl implements LecturerService {

    private static LecturerService lecturerService = null;
    private LecturerRepository lecturerRepository;

    private LecturerServiceImpl() {
        this.lecturerRepository = LecturerRepositoryImpl.getLecturerRepository();
    }

    public static LecturerService getLecturerService() {
        if (lecturerService == null) {
            lecturerService = new LecturerServiceImpl();
        }

        return lecturerService;
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.lecturerRepository.create(lecturer);
    }

    @Override
    public Lecturer read(Long l) {
        return this.lecturerRepository.read(l);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.lecturerRepository.update(lecturer);
    }

    @Override
    public boolean delete(Long l) {
        return this.lecturerRepository.delete(l);
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.lecturerRepository.getAll();
    }

}
