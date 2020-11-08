package za.ac.cput.elective.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.elective.entity.Room;
/**
 * @author Sinethemba Poni
 * Desc: Interface for the RoomRepository.
 * Date: 2020/08/27
 **/

@Repository
public interface RoomRepository extends JpaRepository<Room, String>{

}

