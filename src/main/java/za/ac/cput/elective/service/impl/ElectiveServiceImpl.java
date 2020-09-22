package za.ac.cput.elective.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.repository.ElectiveRepository;
import za.ac.cput.elective.repository.impl.ElectiveRepositoryImpl;
import za.ac.cput.elective.service.ElectiveService;
import java.util.*;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Created ElectiveServiceImpl which extends ElectiveService
 * Date: 06/09/2020
 **/
    @Service
public class ElectiveServiceImpl implements ElectiveService {

    private static ElectiveService eService = null;
    private ElectiveRepository eRepo;

    private ElectiveServiceImpl(){
        this.eRepo = ElectiveRepositoryImpl.getRepository();
    }

    public static ElectiveService getElectiveService(){
        if (eService == null){
            eService = new ElectiveServiceImpl();
        }

        return eService;
    }

    @Override
    public Elective create(Elective elect) {
        return this.eRepo.create(elect);
    }

    @Override
    public Elective read(String s) {
        return this.eRepo.read(s);
    }

    @Override
    public Elective update(Elective elect) {
        return this.eRepo.update(elect);
    }

    @Override
    public boolean delete(String s) {
        return this.eRepo.delete(s);
    }

    @Override
    public Set<Elective> getAll() {
        return this.eRepo.getAll();
    }
}
