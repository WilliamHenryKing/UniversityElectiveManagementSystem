package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Faculty;

/**
 * @author: Ridhaa Hendricks, GitHub: ridhaahendricks
 * Desc: Created FacultyFaculty.java and addFaculty to add a Faculty.
 * Date: 3rd July 2020
 */

public class FacultyFactory {

    public static Faculty addFaculty(String facultyID, String facultyName){
        Faculty facu = new Faculty.Builder()
                .setFacultyID(facultyID)
                .setFacultyName(facultyName)
                .build();
        return facu;
    }

}
