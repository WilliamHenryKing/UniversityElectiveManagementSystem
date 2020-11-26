package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.service.IDGenerator;

import java.util.*;
public class ElectiveFactory {


    public static Elective createElective(String electCode, String electName) {
        Elective elect = new Elective.Builder()
                .setElectCode(electCode)
                //.setElectCode(IDGenerator.generateId())
                .setElectName(electName)
                .build();
        return elect;
    }




}
