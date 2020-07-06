package za.ac.cput.elective.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.elective.entity.Room;

import static org.junit.Assert.*;
/*
 * @author          : Sinethemba Poni 213276968
 * Desc             : Factory for the Room class
 * Date             : 5 July 2020
 */
public class RoomFactoryTest {

    @Test
    public void createRoom() {

        Room room = new RoomFactory().createRoom(" Room One ", 35);

        Assert.assertNotEquals(room.getRoomNumSeats(),100);
        Assert.assertEquals("Room one", room.getRoomNum());



    }
}