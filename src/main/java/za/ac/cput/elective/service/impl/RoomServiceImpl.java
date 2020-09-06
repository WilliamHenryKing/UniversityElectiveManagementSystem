package za.ac.cput.elective.service.impl;

import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.repository.RoomRepository;
import za.ac.cput.elective.repository.impl.RoomRepositoryImpl;
import za.ac.cput.elective.service.RoomService;

import java.util.Set;

/**
 * @author      : Sinethemba Poni 213276968
 * Desc         : The implementation of the RoomService.
 * Date         : 06/09/2020
 **/

public class RoomServiceImpl implements RoomService {

    public static RoomService roomService = null;
    private RoomRepository roomRepository;

    private RoomServiceImpl(){
        this.roomRepository = RoomRepositoryImpl.getRoomRepository();
    }

    public static RoomService getRoomService(){
        if (roomService == null) roomService = new RoomServiceImpl();
        return roomService;
    }

    @Override
    public Set<Room> getAll() {
        return this.roomRepository.getAll();
    }

    @Override
    public Room create(Room room) {
        return this.roomRepository.create(room);
    }

    @Override
    public Room read(String s) {
        return this.roomRepository.read(s);
    }

    @Override
    public Room update(Room room) {
        return this.roomRepository.update(room);
    }

    @Override
    public boolean delete(String s) {
        return this.roomRepository.delete(s);
    }
}
