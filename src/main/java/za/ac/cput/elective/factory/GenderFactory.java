package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Gender;

/**
 * @author @WilliamHenryKing
 * Desc: Factory for Gender
 * Date: 2020/07/05
 **/

public class GenderFactory {

    public static Gender createGender(Gender.genderIs genderIs) {

        return new Gender.Builder()
                .setGenderID(genderIs)
                .build();
    }

}
