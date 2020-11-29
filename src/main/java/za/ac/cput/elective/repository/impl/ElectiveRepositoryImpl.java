/*package za.ac.cput.elective.repository.impl;


import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.repository.ElectiveRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("ElectiveInMemory")

public class  ElectiveRepositoryImpl implements ElectiveRepository {

    private static ElectiveRepositoryImpl eRepo = null;
    private Set<Elective> electiveDB;

    //CONSTRUCTOR
    public ElectiveRepositoryImpl() {
        this.electiveDB = new HashSet<>();
    }
    public static ElectiveRepositoryImpl getElectiveRepository(){
        if (eRepo == null){
            return new ElectiveRepositoryImpl();
        }
        return eRepo;
    }

    //create, read, update, and delete methods

    //CREATE METHOD
    public Elective create(Elective elective){
        this.electiveDB.add(elective);
        return elective;
    }
    //READ METHOD
    public Elective read(String electCode){
        return electiveDB.stream().filter(elective -> elective
                .getElectCode()
                .equals(electCode))
                .findAny()
                .orElse(null);
    }
    //UPDATE METHOD
    //@Override
    public Elective update(Elective elective) {

        Elective inDB = read(elective.getElectCode());

        if(inDB != null){
            electiveDB.remove(inDB);
            electiveDB.add(elective);
            return elective;
        }

        return null;
    }//end of the UPDATE method

    //DELETE METHOD/
    //@Override
    public void delete(String electCode) {

        Elective inDB = read(electCode);
        electiveDB.remove(inDB);
    }//end of delete method

    //@Override
    public Set<Elective> getAll() {
        return electiveDB;
    }
}*/
