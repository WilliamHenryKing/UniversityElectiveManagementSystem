package za.ac.cput.elective.service;

/**
 * @author @Wasiem Cassiem
 * Desc: This is an Interface for MarkService
 * Date: 6 September 2020
 **/

import za.ac.cput.elective.entity.Mark;
import java.util.Set;

public interface MarkService extends IService<Mark, String>
{
    Set<Mark> getAll();
}