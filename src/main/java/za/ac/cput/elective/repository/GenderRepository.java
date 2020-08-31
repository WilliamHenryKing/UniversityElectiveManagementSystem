package za.ac.cput.elective.repository;


import za.ac.cput.elective.entity.Gender;

import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for GenderRepository
 * Date: 2020/08/30
 **/

public interface GenderRepository extends IRepository<Gender, Character> {
    Set<Gender> getAll();
}
