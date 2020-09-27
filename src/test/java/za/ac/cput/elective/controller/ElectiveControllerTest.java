package za.ac.cput.elective.controller;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)

 public class ElectiveControllerTest {

    private Elective elective = ElectiveFactory.createElective("BA","Data Structures");
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/elective/";

    @Test
    public void a_create(){
        String url = baseURL + "create/";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + elective);
        ResponseEntity<Elective> postResponse = restTemplate.postForEntity(url, elective, Elective.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        elective = postResponse.getBody();
        System.out.println("Saved data: " + elective);
        assertEquals(elective.getElectName(),postResponse.getBody().getElectName());

        /*the test's fails but the elective details are still created,
        but I gave up on trying to fix it after a few hours.
        */
    }


    @Test
    public void b_read(){
        ResponseEntity<Elective> getResponse = restTemplate.getForEntity(baseURL
                        + "read/" + elective.getElectName()
                        + elective.getElectDesc(),
                Elective.class);
        assertEquals(elective.getElectName() + elective.getElectDesc(),
                Objects.requireNonNull(getResponse.getBody()).getElectName(),
                getResponse.getBody().getElectDesc());
        System.out.println(getResponse.getBody());

        /*Test Fails, I even tried it my group members way and still fails.*/
    }

    @Test
    public void c_modify() {

        String old = elective.getElectName() + elective.getElectDesc();
        AtomicReference<Elective> modified = new AtomicReference<>(new Elective.Builder()
                .copy(elective)
                .setElectName("BA")
                .setElectDesc("Data Structures")
                .build());
        ResponseEntity<Elective> changedResponse = restTemplate.postForEntity(baseURL + "change", elective,
                Elective.class);
        assertNotEquals(old, Objects.requireNonNull(changedResponse.getBody()).getElectName());
        System.out.println("Modified: " + modified);
        /*Test Fails, I even tried it my group members way and still fails.
        After hours of trying different methods to try and fix the problem.*/
    }

    @Test
    public void d_delete(){
        String url = baseURL + "delete/"+ "  " + elective.getElectName() + "  and: " + elective.getElectDesc();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

        /*Works!!! it actually deletes the details created.*/
    }

    @Test
    public void getAll(){
        String url = baseURL + "all/";
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
        /*Works!!!*/
    }

}