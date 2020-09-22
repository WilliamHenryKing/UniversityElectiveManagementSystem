package za.ac.cput.elective.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Student;
import za.ac.cput.elective.factory.StudentFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String baseURL = "http://localhost:8080/student/";
    private static Student s = StudentFactory.createStudent(2, "AppDev");
    @Test
    public void create() {

        String url = baseURL + "create";
        ResponseEntity<Student> r = restTemplate.postForEntity(url, s, Student.class);
        assertNotNull(r);
        assertNotNull(r.getBody());

        System.out.println(r.getBody());

    }

    @Test
    public void read() {
        String url = baseURL + "read/" + s.getStudentID();
        ResponseEntity<Student> r = restTemplate.getForEntity(url, Student.class);
        assertEquals(s.getStudentID(), r.getBody().getStudentID());
    }

    @Test
    public void update() {
        Student u = new Student.Builder().copy(s).setStudentID("230").build();
        String url = baseURL + "update";
        ResponseEntity<Student> r = restTemplate.postForEntity(url, u, Student.class);
        assertEquals(s.getStudentID(), r.getBody().getStudentID());
    }

    @Test
    public void delete() {
        String url = baseURL + "delete/" + s.getStudentID();
        restTemplate.delete(url);
    }

    @Test
    public void getAll() {
        String url = baseURL + "all";
        HttpHeaders h = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, h);
        ResponseEntity<String> r = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(r);
        System.out.println(r.getBody());
    }
}