package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Elective;

import java.util.UUID;

public class ElectiveFactory {


    public static Elective createElective(long electCode, String electName) {
        String electDesc = UUID.randomUUID().toString();
        Elective elect = new Elective.Builder()
                .setElectName(electDesc)
                .setElectCode(electCode)
                .setElectName(electName)
                .build();
        return elect;
    }




}

