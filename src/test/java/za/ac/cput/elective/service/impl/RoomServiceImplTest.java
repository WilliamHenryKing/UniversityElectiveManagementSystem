package za.ac.cput.elective.service.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.factory.RoomFactory;
import za.ac.cput.elective.service.RoomService;

import java.util.Set;

import static org.junit.Assert.*;
/**
 * @author      : Sinethemba Poni 213276968
 * Desc         : Test code for the RoomServiceImpl
 * Date         : 06/09/2020
 **/
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomServiceImplTest {



    @Autowired
    private static RoomService roomService;
    private static Room room = RoomFactory.createRoom("Room 1", 29);

    @Test
    public void d_getAll() {
        Set<Room> rooms = roomService.getAll();
        assertEquals(1, rooms.size());
        System.out.println("All rooms: " +rooms);
    }


    @Test
    public void a_create() {
        Room created = roomService.create(room);
        Assert.assertEquals(room.getRoomNum(), created.getRoomNum());
        System.out.println("Created: " +created);
    }

    @Test
    public void b_read() {
        Room read = roomService.read(room.getRoomNum());
        System.out.println("Read: " +read);
    }

    @Test
    public void c_update() {
           Room updated =  new Room
                        .Builder()
                        .copy(room)
                        .setRoomNum("Room number 1")
                        .build();
                updated = roomService.update(updated);
                System.out.println("Updated" +updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = roomService.delete(room.getRoomNum());
        Assert.assertTrue(deleted);System.out.println("Deleted..." +deleted);
    }
}