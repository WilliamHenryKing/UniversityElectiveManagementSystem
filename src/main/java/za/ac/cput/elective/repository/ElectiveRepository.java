package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Elective;

import java.util.Set;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Interface for ElectiveRepository
 * Date: 26/08/2020
 **/

public interface ElectiveRepository extends IRepository <Elective, String> {
    Set<Elective> getAll();
}
