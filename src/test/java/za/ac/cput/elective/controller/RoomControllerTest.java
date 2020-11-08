package za.ac.cput.elective.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Room;
import za.ac.cput.elective.factory.RoomFactory;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RoomControllerTest {

    private static Room room = RoomFactory.createRoom("Room one", 34);

    public static String SECURITY_USERNAME = "admin";
    public static String SECURITY_PASSWORD = "psw";


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/room/";

    @Test
    public void a_create() {

                String url = baseURL + "create";
                System.out.println("URL" + url);
                System.out.println("Post data" + room);

                ResponseEntity<Room> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, room, Room.class);


                 assertNotNull(postResponse);
                 assertNotNull(postResponse.getBody());
                 System.out.println("Saved data:" + room);
                 assertEquals(room.getRoomNum(), postResponse.getBody().getRoomNum());

    }

    @Test
    public void b_read() {

                String url = baseURL + "read/" +room.getRoomNum();
                System.out.println(url);
                ResponseEntity<Room> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Room.class);

                System.out.println(response.getBody());
                assertEquals(room.getRoomNum(), response.getBody().getRoomNum());
                System.out.println("Added data:" +response);

    }

    @Test
    public void c_update() {

                Room update = new Room.Builder().copy(room).setRoomNum("Room 1").build();
                String url = baseURL +"update";
                ResponseEntity<Room> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, update, Room.class);
                assertNotNull(room.getRoomNum(), responseEntity.getBody().getRoomNum());
                System.out.println("Successfully updated..." +responseEntity.getBody());


    }

    @Test
    public void d_getAll() {

                String url = baseURL + "all";
                HttpHeaders hHeades = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity<>(null, hHeades);
                ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

                System.out.println(response);
                System.out.println(response.getBody());

    }

    @Test
    public void f_delete() {
                String url = baseURL + "delete/" + room.getRoomNum();
                restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);

    }
}