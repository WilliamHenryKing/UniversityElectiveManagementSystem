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
import za.ac.cput.elective.factory.GenderFactory;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class GenderControllerTest {

    private static Gender gender = new GenderFactory().createGender('F'); // creates female gender
    private static String username_admin_security = "admin";
    private static String password_admin_security = "psw";

    private static String username_lecturer_security = "lecturer";
    private static String password_lecturer_security = "password2";

    private static String username_student_security = "student";
    private static String password_student_security = "password";

    @Autowired
    private TestRestTemplate testRestTemplate;
    private String baseURL = "http://localhost:8080/gender/";

    @Test
    public void a_create() {

        ResponseEntity<Gender> postResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .withBasicAuth(username_student_security, password_student_security)
                .postForEntity(
                baseURL + "create",
                gender,
                Gender.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Data:\n\n" + gender);

    }

    @Test
    public void b_read() {

        ResponseEntity<Gender> showResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .withBasicAuth(username_student_security, password_student_security)
                .getForEntity(baseURL +
                        "read/" +
                        gender.getGenderID(),
                Gender.class);

        assertEquals(gender.getGenderID(), showResponse.getBody().getGenderID());

    }

    @Test
    public void c_update() {

        Gender genderUpdated = new Gender
                .Builder()
                .copy(gender)
                .setGenderID('U')
                .build();

        ResponseEntity<Gender> updatedResponse = testRestTemplate
                .withBasicAuth(username_admin_security, password_admin_security)
                .withBasicAuth(username_lecturer_security, password_lecturer_security)
                .withBasicAuth(username_student_security, password_student_security)
                .postForEntity(
                baseURL + "update",
                genderUpdated,
                Gender.class);

        assertEquals(gender.getGenderID(),
                updatedResponse.getBody().getGenderID());

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
                .delete(baseURL + "delete/" + gender.getGenderID());
    }
}