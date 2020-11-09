package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin faculty = (Admin) o;
        return adminID.equals(faculty.adminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID);
    }


} // end of Admin class

