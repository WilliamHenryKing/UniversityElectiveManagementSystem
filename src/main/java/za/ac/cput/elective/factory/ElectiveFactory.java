package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Elective;

import java.util.*;
public class ElectiveFactory {


    public static Elective createElective(long electCode, String electName) {
        Elective elect = new Elective.Builder()
                .setElectCode(electCode)
                .setElectName(electName)
                .build();
        return elect;
    }




}
