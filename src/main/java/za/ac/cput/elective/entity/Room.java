package za.ac.cput.elective.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/*
 * @author          : Sinethemba Poni 213276968
 * Desc             : Romm.java class with its attributes using the Builder pattern
 * Date             : 5 July 2020
 */
@Entity

public class Room {
    @Id
    private String roomNum;
    private int roomNumSeats;

    protected Room (){}

    private Room(Builder builder) {
        this.roomNum = builder.roomNum;
        this.roomNumSeats = builder.roomNumSeats;
    }


    public String getRoomNum() {
        return roomNum;
    }

    public int getRoomNumSeats() {
        return roomNumSeats;
    }


    @Override
    public String toString() {
        return "Room{" +
                "Room number='" + roomNum + '\'' +
                ", Number of seats in room='" + roomNumSeats + '\'' +
                '}';
    }

    public static class Builder {
        private String roomNum;
        private int roomNumSeats;

        public Builder setRoomNum(String roomNum) {
            this.roomNum = roomNum;
            return this;
        }

        public Builder setRoomNumSeats(int roomNumSeats) {
            this.roomNumSeats = roomNumSeats;
            return this;
        }

        public Builder copy(Room room) {
            this.roomNum = room.roomNum;
            this.roomNumSeats = room.roomNumSeats;
            return this;
        }



        public Room build() {
            return new Room(this);
        }

    }


    @Override
    public  boolean equals (Object o){
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNum.equals(room.roomNum);
    }

    @Override
    public int hashCode() {return Objects.hash(roomNum);
    }

}
