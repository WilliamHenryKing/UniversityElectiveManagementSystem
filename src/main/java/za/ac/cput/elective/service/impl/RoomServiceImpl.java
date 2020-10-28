package za.ac.cput.elective.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.repository.RoomRepository;
//import za.ac.cput.elective.repository.impl.RoomRepositoryImpl;
import za.ac.cput.elective.service.RoomService;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author      : Sinethemba Poni 213276968
 * Desc         : The implementation of the RoomService.
 * Date         : 06/09/2020
 **/
@Service
public class RoomServiceImpl implements RoomService {

    public static RoomService roomService = null;
    @Autowired
    private RoomRepository roomRepository;

//    private RoomServiceImpl(){
//        this.roomRepository = RoomRepositoryImpl.getRoomRepository();
//    }
//
//    public static RoomService getRoomService(){
//        if (roomService == null) roomService = new RoomServiceImpl();
//        return roomService;
//    }


//    @Override
//    public Set<Room> getAll() {
//        return this.roomRepository.getAll();
//    }


 @Override
 public Set<Room> getAll() {return this.roomRepository.findAll().stream().collect(Collectors.toSet());}

    @Override
    public Room create(Room room) {
        return this.roomRepository.save(room);

    }

    @Override
    public Room read(String s) {
        return this.roomRepository.findById(s).orElseGet(null);
    }



     @Override
    public Room update(Room room) {
        if (this.roomRepository.existsById(room.getRoomNum())) {
            return this.roomRepository.save(room);
        }
        return null;
    }


    @Override
    public boolean delete(String s) {
        this.roomRepository.deleteById(s);
        if(this.roomRepository.existsById(s)) return false;
        else return true;
    }
}
