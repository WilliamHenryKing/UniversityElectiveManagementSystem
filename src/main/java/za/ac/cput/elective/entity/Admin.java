package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author @plex303
 * Desc: Admin entity
 * Date: 4 July 2020
 */

@Entity
public class Admin {

    @Id
    private String adminID;
    private String adminName;

    protected Admin(){}

    public Admin(AdminBuilder builder) {
        this.adminID = builder.adminID;
        this.adminName = builder.adminName;
    }



    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminName='" + adminName + '\'' +
                '}';
    }

    // getters

    public String getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }


    // builder class

    public static class AdminBuilder{
        private String adminID;
        private String adminName;

        // setters

        public AdminBuilder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public AdminBuilder setAdminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        // copy method

        public AdminBuilder copy(Admin admin){
            this.adminID = admin.adminID;
            this.adminName= admin.adminName;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }


    } // end of AdminBuilder class


    // displays selected elective details
    public void viewElectApplication(){

    }

    // adds new elective
    public void addElective(){

    }

    // deletes an elective
    public void deleteElective(){

    }

    // modifies elective details
    public void modifyElective(){

    }


} // end of Admin class

