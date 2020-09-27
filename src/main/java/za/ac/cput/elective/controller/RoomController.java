package za.ac.cput.elective.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.factory.RoomFactory;
import za.ac.cput.elective.service.impl.RoomServiceImpl;
import java.io.Serializable;
import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create(@RequestBody Room room){
        Room rm = RoomFactory.createRoom(
                room.getRoomNum(),
                room.getRoomNumSeats());

                return roomService.create(rm);

    }

    @GetMapping("/read/{roomNum}")
    public Room read(@PathVariable String roomNum){
        return roomService.read(roomNum);
    }


    @GetMapping("/update")
    public Room update (@RequestBody Room room){
        return  roomService.update(room);

    }

    @GetMapping("/all")
    public Set<Room> getAll() {
        return roomService.getAll();
    }

    @DeleteMapping("/delete/{roomNum}")
    public boolean delete(@PathVariable String roomNum){
        return roomService.delete(roomNum);
    }

}
