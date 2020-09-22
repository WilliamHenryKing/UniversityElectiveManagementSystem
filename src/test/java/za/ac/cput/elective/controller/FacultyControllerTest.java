package za.ac.cput.elective.controller;

import org.apache.coyote.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.FacultyFactory;

import java.net.http.HttpHeaders;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class FacultyControllerTest {

    private static Faculty facu;

    @Autowired
    private TestRestTemplate tRestTemp;
    private String baseURL = "http://localhost:8080/race";

    @Test
    public void create() {
        facu  = FacultyFactory.addFaculty("1234", "ENgieeeering");

        ResponseEntity<Faculty> postResponse = tRestTemp.postForEntity(baseURL + "create", facu, Faculty.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());

        System.out.println(postResponse.getBody());
    }

    @Test
    public void show() {
    }

    @Test
    public void change() {
    }

    @Test
    public void showAll() {
    }

    @Test
    public void delete() {
    }
}