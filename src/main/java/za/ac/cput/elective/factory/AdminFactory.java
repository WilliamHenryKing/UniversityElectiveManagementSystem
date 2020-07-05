package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Admin;

/**
 * Author @plex303
 * Desc: Admin factory
 * Date: 5 July 2020
 */

public class AdminFactory {

    public static Admin buildAdmin(long id, String name){
        return new Admin.AdminBuilder().setAdminID(id).setAdminName(name).build();

    } //end of buildAdmin
} //end of AdminFactory
