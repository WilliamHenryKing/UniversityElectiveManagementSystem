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
import za.ac.cput.elective.entity.Gender;
import za.ac.cput.elective.entity.Lecturer;
import za.ac.cput.elective.factory.GenderFactory;
import za.ac.cput.elective.factory.LecturerFactory;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LecturerControllerTest {

    private static Lecturer lecturer = LecturerFactory.createLecturer(621548793
            , "Anikwue"
            , "Arinze"
            , 'M');

    private static String username_admin_security = "admin";
    private static String password_admin_security = "psw";

    private static String username_lecturer_security = "lecturer";
    private static String password_lecturer_security = "password2";

    private static String username_student_security = "student";
    private static String password_student_security = "password";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/lecturer/";

    @Test
    public void a_create() {

        ResponseEntity<Lecturer> postResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .postForEntity(
                baseURL + "create",
                lecturer,
                Lecturer.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Data:\n\n" + lecturer);

    }

    @Test
    public void b_read() {

        ResponseEntity<Lecturer> showResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .withBasicAuth(username_student_security, password_student_security)
                .getForEntity(baseURL +
                        "read/" +
                        lecturer.getLecturerID(),
                Lecturer.class);

        assertEquals(lecturer.getLecturerID(), showResponse.getBody().getLecturerID());

    }

    @Test
    public void c_update() {

        Lecturer lecturerUpdated = new Lecturer
                .Builder()
                .copy(lecturer)
                .setLecturerID(62228514)
                .build();

        ResponseEntity<Lecturer> updatedResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .postForEntity(
                baseURL + "update",
                lecturerUpdated,
                Lecturer.class);

        assertEquals(lecturer.getLecturerID(),
                updatedResponse.getBody().getLecturerID());

    }

    @Test
    public void d_getAll() {

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> stringHttpEntity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> theResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .exchange(
                baseURL + "all",
                HttpMethod.GET,
                stringHttpEntity,
                String.class);

        System.out.println(theResponse);
        System.out.println(theResponse.getBody());

    }

    @Test
    public void e_delete() {
        testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .delete(baseURL + "delete/" + lecturer.getLecturerID());
    }
}