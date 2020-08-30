package za.ac.cput.elective.repository;

import za.ac.cput.elective.entity.Room;
/**
 * @author Sinethemba Poni
 * Desc: Interface for the RoomRepository.
 * Date: 2020/08/27
 **/
import java.util.Set;

public interface RoomRepository extends IRepository <Room, String> {
    Set<Room> getAll();
}
