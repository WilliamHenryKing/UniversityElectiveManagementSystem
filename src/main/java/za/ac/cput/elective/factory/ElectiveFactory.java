package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Elective;

import java.util.*;
public class ElectiveFactory {


    public static Elective createElective(String electName, String electDesc) {
        String electCode = UUID.randomUUID().toString();
        Elective elect = new Elective.Builder()
                .setElectName(electCode)
                .setElectName(electName)
                .setElectDesc(electDesc)
                .build();
        return elect;
    }




}

