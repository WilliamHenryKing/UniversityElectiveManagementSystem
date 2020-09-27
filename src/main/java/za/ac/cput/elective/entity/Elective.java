package za.ac.cput.elective.entity;
/*
 * @author: Shane  Mapasie, GitHub: SPMapasie216182425
 * Desc: Create Elective.java class with attributes using the Builder pattern
 * Date: 4rd July 2020
 */

public class Elective  {

    /* Encapsulation */
    private String electName;
    private long electCode;
    private String electDesc;

    /* constructor */
    private Elective(Builder b) {
        this.electName = b.electName;
        this.electCode = b.electCode;
        this.electDesc = b.electDesc;
    }

    //getters
    public String getElectName() {
        return electName;
    }

    public long getElectCode() {
        return electCode;
    }

    public String getElectDesc() {
        return electDesc;
    }

    //toString Method
    @Override
    public String toString() {
        return "Elective{" +
                "Elective Name=" + electName +
                ", Elective Code=" + electCode +
                ", Elective Description='" + electDesc + '\'' +
                '}';
    }

    public static class Builder {

        private String electName;
        private long electCode;
        private String electDesc;

        /* setters using builder */
        public Builder setElectName(String electName) {
            this.electName = electName;
            return this;
        }

        public Builder setElectCode(long electCode) {
            this.electCode = electCode;
            return this;
        }

        public Builder setElectDesc(String electDesc) {
            this.electDesc = electDesc;
            return this;
        }

        /*Constructor with Builder Implemented*/
        public Builder copy(Elective elect) {
            this.electName = elect.electName;
            this.electCode = elect.electCode;
            this.electDesc = elect.electDesc;
            return this;
        }

        /*Methods*/
        public Elective build() {
            return new Elective(this);
        }

    }
}


