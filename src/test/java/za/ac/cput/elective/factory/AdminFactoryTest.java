package za.ac.cput.elective.factory;
/**
 * Author @plex303
 * Desc: Admin factory test
 * Date: 5 July 2020
 */
import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Admin;

import static org.junit.Assert.*;

public class  AdminFactoryTest {

    @Test
    public void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin("123","Ronald");
        Assert.assertNotEquals(admin.getAdminID(),321);
    }
}