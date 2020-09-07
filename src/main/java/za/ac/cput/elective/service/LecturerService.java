package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.repository.IRepository;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for LecturerService
 * Date: 2020/09/06
 **/

public interface LecturerService extends IRepository<Lecturer, Long> {
    Set<Lecturer> getAll();
}
