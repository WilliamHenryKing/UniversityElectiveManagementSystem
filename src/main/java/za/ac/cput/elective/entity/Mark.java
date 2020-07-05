package za.ac.cput.elective.entity;

/*
 * @author: Wasiem Cassiem , GitHub: Wasiem1908
 * Desc: Create Mark.java class with attributes using the Builder pattern
 * Date: 07 July 2020
 */

public class Mark
{
    private String marksID;

    private Mark(Builder builder)
    {
        this.marksID = builder.marksID;
    }


    public static class Builder
    {
        private String marksID;

        public Builder setMarksID(String markID)
        {
            this.marksID = markID;
            return this;
        }

        public Builder copy (Mark mark)
        {
            this.marksID = mark.marksID;
            return this;
        }

        public Mark build()
        {
            return new Mark(this);
        }
    }

    public String getMarksID()
    {
        return marksID;
    }

    public String ReadSubjectID (Long electCode)
    {
        // Returns subject ID code based on specific subject for elective.

        return "";
    }

    public void CalWeight()
    {
        // Calculates the weight of the mark.
    }

    public void sendMark()
    {
        // Gets mark and displays it on the GUI.
    }

    public void ViewFinalMark()
    {
        // Displays final mark on GUI after all the weighting is taken into consideration.
    }

    @Override
    public String toString()
    {
        return "Mark ID: " + marksID;
    }
}

