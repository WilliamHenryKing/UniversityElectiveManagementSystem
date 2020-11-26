package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.repository.ElectiveRepository;
import za.ac.cput.elective.service.ElectiveService;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @ShanePhumlaniMapasie
 * Desc: Created ElectiveServiceImpl which extends ElectiveService
 * Date: 06/09/2020
 **/
@Service
public class ElectiveServiceImpl implements ElectiveService {

    private static ElectiveService eService = null;
    @Autowired
    private ElectiveRepository eRepo;
    /*
     private ElectiveServiceImpl(){
         this.eRepo = ElectiveRepositoryImpl.getRepository();
     }
     public static ElectiveService getElectiveService(){
         if (eService == null){
             eService = new ElectiveServiceImpl();
         }
         return eService;
     }
   */
    @Override
    public Elective create(Elective elective) {

        return this.eRepo.save(elective);

    }

   @Override
    public Elective read(String s) {
        return this.eRepo.findById(s).orElseGet(null);
    }

    @Override
    public Elective update(Elective elective) {
        if(this.eRepo.existsById(elective.getElectCode())) {
            return this.eRepo.save(elective);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.eRepo.deleteById(s);
        return !this.eRepo.existsById(s);
    }

    @Override
    public Set<Elective> getAll() {
        Set<Elective> collect = this.eRepo.findAll()
                .stream()
                .collect(Collectors.toSet());
        return collect;
    }
}