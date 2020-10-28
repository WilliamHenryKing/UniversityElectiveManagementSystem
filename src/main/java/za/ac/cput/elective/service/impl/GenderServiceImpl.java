package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.repository.GenderRepository;
//import za.ac.cput.elective.repository.impl.GenderRepositoryImpl;
import za.ac.cput.elective.service.GenderService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @WilliamHenryKing
 * Desc: Implementation for GenderService
 * Date: 2020/09/06
 **/
@Service
public class GenderServiceImpl implements GenderService {

    private static GenderService genderService = null;

    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Gender create(Gender gender) {
        return this.genderRepository.save(gender);
    }

    @Override
    public Gender read(Character c) {
        return this.genderRepository
                .findById(c)
                .orElseGet(null);
    }

    @Override
    public Gender update(Gender gender) {
        if (this.genderRepository.existsById(gender.getGenderID())) {
            return this.genderRepository.save(gender);
        }
        return null;
    }

    @Override
    public boolean delete(Character c) {
        this.genderRepository.deleteById(c);
        if (this.genderRepository.existsById(c)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Set<Gender> getAll() {
        return this.genderRepository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }

}
