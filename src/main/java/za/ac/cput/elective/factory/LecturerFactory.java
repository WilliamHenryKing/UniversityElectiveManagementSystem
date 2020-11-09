package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.entity.Lecturer;

/**
 * @author @WilliamHenryKing
 * Desc: Factory for Lecturer
 * Date: 2020/07/05
 **/

public class LecturerFactory {

    public static Lecturer createLecturer(long lecturerID,
                                          String lecturerLName,
                                          String lecturerFName,
                                          char genderID) {

        return new Lecturer.Builder()
                .setLecturerID(lecturerID)
                .setLecturerLName(lecturerLName)
                .setLecturerFName(lecturerFName)
                .setGender(genderID)
                .build();

    }

}