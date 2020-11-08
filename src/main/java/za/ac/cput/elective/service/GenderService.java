package za.ac.cput.elective.service;


import za.ac.cput.elective.entity.Gender;
import java.util.Set;

/**
 * @author @WilliamHenryKing
 * Desc: Interface for GenderService
 * Date: 2020/09/06
 **/

public interface GenderService extends IService<Gender, Character> {
    Set<Gender> getAll();
}