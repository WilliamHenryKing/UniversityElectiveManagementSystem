package za.ac.cput.elective.repository.impl;

/**
 * @author Sinethemba Poni
 * Desc: Test for the RoomRepository
 * Date: 2020/08/27
 **/
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.factory.RoomFactory;
import za.ac.cput.elective.repository.RoomRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomRepositoryImplTest {
    private static RoomRepository roomRepository = RoomRepositoryImpl.getRoomRepository();
    private static Room room = RoomFactory.createRoom("Room One", 29);

    @Test
    public void getRoomRepository() {
    }

    @Test
    public void a_create() {
        Room created = roomRepository.create(room);
        Assert.assertEquals(room.getRoomNum(), created.getRoomNum());
        System.out.println("Succesfully created: " +created);
    }

    @Test
    public void b_read() {
        Room read = roomRepository.read(room.getRoomNum());
        System.out.println("Read.." +read);

    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setRoomNum("Room Two").build();
        updated = roomRepository.update(updated);
        System.out.println("Succesfully updated:" +updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = roomRepository.delete(room.getRoomNum());
        Assert.assertTrue(deleted);
        System.out.println("Succesfully deleted:"+ deleted);


    }

    @Test
    public void d_getAll() {
        System.out.println("Get all:" +roomRepository.getAll());
    }
}