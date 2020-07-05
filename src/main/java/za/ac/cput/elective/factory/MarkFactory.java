package za.ac.cput.elective.factory;

/*
 * @author: Wasiem Cassiem , GitHub: Wasiem1908
 * Desc: Create MarkFactory.java class
 * Date: 07 July 2020
 */

import za.ac.cput.elective.entity.Mark;

public class MarkFactory
{
    public  static Mark createMark (String marksID)
    {
        Mark mark = new Mark.Builder().setMarksID(marksID).build();
        return mark;
    }
}
