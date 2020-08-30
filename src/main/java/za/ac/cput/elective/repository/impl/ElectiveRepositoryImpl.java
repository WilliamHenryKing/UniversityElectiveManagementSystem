package za.ac.cput.elective.repository.impl;

import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.repository.ElectiveRepository;
//import za.ac.cput.elective.repository.Repository;


import java.util.*;

public class  ElectiveRepositoryImpl implements ElectiveRepository{

    private Set<Elective> electiveDB;

    /*CONSTRUCTOR*/
    public ElectiveRepositoryImpl() {
        this.electiveDB = new HashSet<>();
    }

    /*create, read, update, and delete methods*/

    /*CREATE METHOD*/
    public Elective create(Elective elective){
        this.electiveDB.add(elective);
        return elective;
    }
    /*READ METHOD*/
    public Elective read(String electName){
        Elective elective = null;
        for(Elective elec: this.electiveDB) {

            if(elec.getElectName().equalsIgnoreCase(electName)){
                elective = elec;
                break;
            } //end of if statement
        }//end of the for loop
        return elective;
    }
    /*UPDATE METHOD*/
    public Elective update(Elective elective){
        Elective oldElective = read(elective.getElectCode()+elective.getElectName());
        if(oldElective != null){
            this.electiveDB.remove(oldElective);
            this.electiveDB.add(elective);
        }//end of if statement
        return elective;
    }//end of the UPDATE method

    /*DELETE METHOD*/
    public boolean delete(String electName){
        Elective elective = read(electName);
        if(elective != null) this.electiveDB.remove(elective);{
        }
        return false;
    }//end of delete method

    @Override
    public Set<Elective> getAll() {
        return electiveDB;
    }
}
