package za.ac.cput.elective.factory;

/*
 * @author: Wasiem Cassiem , GitHub: Wasiem1908
 * Desc: Create MarkFactory.java class
 * Date: 07 July 2020
 */

import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.service.IDGenerator;

public class MarkFactory
{
    public  static Mark createMark (String marksID)
    {
        //String marksID = IDGenerator.generateId();
        Mark mark = new Mark.Builder().setMarksID(marksID).build();
        return mark;
    }
}
