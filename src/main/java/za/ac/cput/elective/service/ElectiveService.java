package za.ac.cput.elective.service;


import za.ac.cput.elective.entity.Elective;

import java.util.Set;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Interface for ElectiveService
 * Date: 05/09/2020
 **/

public interface ElectiveService extends IService<Elective, String> {
    Set<Elective> getAll();
}