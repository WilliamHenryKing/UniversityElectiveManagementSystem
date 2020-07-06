package za.ac.cput.elective.factory;

import za.ac.cput.elective.entity.Room;
/*
 * @author          : Sinethemba Poni 213276968
 * Desc             : Romm factory
 * Date             : 5 July 2020
 */

public class RoomFactory {

    public static Room createRoom( String roomNum, int roomNumSeats ) {

        Room room = new Room.Builder()
                .setRoomNum(roomNum)
                .setRoomNumSeats(roomNumSeats)
                .build();
        return room;

    }


}
