package za.ac.cput.elective.service;

import za.ac.cput.elective.entity.Room;

import java.util.Set;
/**
 * @author  :  Sinethemba Poni 213276968
 * Desc     :  RoomService Interface.
 * Date     :  06/09/2020
 **/

public interface RoomService extends IService <Room, String> {
    Set<Room>getAll();
}
