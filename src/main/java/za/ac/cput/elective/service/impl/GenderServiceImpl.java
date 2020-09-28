package za.ac.cput.elective.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.repository.GenderRepository;
import za.ac.cput.elective.repository.impl.GenderRepositoryImpl;
import za.ac.cput.elective.service.GenderService;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for GenderService
 * Date: 2020/09/06
 **/
@Service
public class GenderServiceImpl implements GenderService {

    private static GenderService genderService = null;
    private GenderRepository genderRepository;

    private GenderServiceImpl() {
        this.genderRepository = GenderRepositoryImpl.getGenderRepository();
    }

    public static GenderService getGenderService() {
        if (genderService == null) {
            genderService = new GenderServiceImpl();
        }

        return genderService;
    }

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.create(gender);
    }

    @Override
    public Gender read(Character c) {
        return this.genderRepository.read(c);
    }

    @Override
    public Gender update(Gender gender) {
        return this.genderRepository.update(gender);
    }

    @Override
    public boolean delete(Character c) {
        return this.genderRepository.delete(c);
    }

    @Override
    public Set<Gender> getAll() {
        return this.genderRepository.getAll();
    }

}
