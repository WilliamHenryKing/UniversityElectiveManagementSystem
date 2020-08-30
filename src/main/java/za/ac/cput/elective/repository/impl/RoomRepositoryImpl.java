package za.ac.cput.elective.repository.impl;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.repository.RoomRepository;
/**
 * @author Sinethemba Poni
 * Desc: Implementation for the RoomRepository..
 * Date: 2020/08/27
 **/
import java.util.HashSet;
import java.util.Set;

public class RoomRepositoryImpl implements RoomRepository {

    private static RoomRepository roomRepository = null;
    private Set<Room> roomDB;

    RoomRepositoryImpl(){
        this.roomDB = new HashSet<>();
    }

    public static RoomRepository getRoomRepository (){
        if(roomRepository == null){
            roomRepository = new RoomRepositoryImpl();
        }
        return roomRepository;
    }



    @Override
    public Room create(Room room) {
        this.roomDB.add(room);
        return room;
    }


    public Room read(String roomNum){
        Room room = null;
        for(Room rm: this.roomDB) {

            if(rm.getRoomNum().equalsIgnoreCase(roomNum)){
                room = rm;
                break;
            }
        }
        return room;
    }


    @Override
    public Room update(Room room) {
        Room oldRoom = read(room.getRoomNum());
            if(oldRoom !=null){
                this.roomDB.remove(oldRoom);
                this.roomDB.add(room);
            }
        return room;
    }

    @Override
    public boolean delete(String roomNum) {
        Room room = read(roomNum);

        if (room !=null){
            this.roomDB.remove(room);
            return true;
        }else {
            return false;
        }
    }


    @Override
    public Set<Room> getAll() {
        return this.roomDB;
    }
}
