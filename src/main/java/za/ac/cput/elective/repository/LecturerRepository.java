package za.ac.cput.elective.repository;


import za.ac.cput.elective.entity.Lecturer;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for LecturerRepository
 * Date: 2020/08/30
 **/

public interface LecturerRepository extends IRepository<Lecturer, Long> {
    Set<Lecturer> getAll();
}
