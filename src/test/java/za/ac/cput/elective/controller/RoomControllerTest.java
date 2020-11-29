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

    public static String USERNAME_ADMIN_SECURITY = "admin";
    public static String PASSWORD_ADMIN_SECURITY = "psw";

    public static String USERNAME_STUDENT_SECURITY = "student";
    public static String PASSWORD_STUDENT_SECURITY = "password2";

    public static String USERNAME_LECTURER_SECURITY = "lecturer";
    public static String PASSWORD_LECTURER_SECURITY = "password";



    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/room/";

    @Test
    public void a_create() {

                String url = baseURL + "create";
                System.out.println("URL" + url);
                System.out.println("Post data" + room);

                ResponseEntity<Room> postResponse = restTemplate
                        .withBasicAuth(USERNAME_ADMIN_SECURITY, PASSWORD_ADMIN_SECURITY)
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

                .withBasicAuth(USERNAME_ADMIN_SECURITY, PASSWORD_ADMIN_SECURITY)
                        .withBasicAuth(USERNAME_LECTURER_SECURITY, PASSWORD_LECTURER_SECURITY)
                        .withBasicAuth(USERNAME_STUDENT_SECURITY, PASSWORD_STUDENT_SECURITY)
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
                .withBasicAuth(USERNAME_ADMIN_SECURITY, PASSWORD_ADMIN_SECURITY)
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
                .withBasicAuth(USERNAME_ADMIN_SECURITY, PASSWORD_ADMIN_SECURITY)
                .exchange(url, HttpMethod.GET, entity, String.class);

                System.out.println(response);
                System.out.println(response.getBody());

    }

    @Test
    public void f_delete() {
                String url = baseURL + "delete/" + room.getRoomNum();
                restTemplate
                .withBasicAuth(USERNAME_ADMIN_SECURITY, PASSWORD_ADMIN_SECURITY)
                .delete(url);

    }
}