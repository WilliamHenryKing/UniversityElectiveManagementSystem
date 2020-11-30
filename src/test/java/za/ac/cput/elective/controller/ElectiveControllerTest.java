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
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;
import static org.junit.Assert.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)

public class ElectiveControllerTest {

    private Elective elective = ElectiveFactory.createElective("0000155", "BNA");

    public static String SECURITY_USERNAME = "doozy";
    public static String SECURITY_PASSWORD = "doozy1";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/elective/";

    @Test
    public void create() {
        String url = baseURL + "create";
        ResponseEntity<Elective> elect = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, elective, Elective.class);
        assertNotNull(elective);
        assertNotNull(elect.getBody());
        System.out.println(elect.getBody());
    }


    @Test
    public void b_read() {

        String url = baseURL + "read/" + elective.getElectCode();
        System.out.println(url);
        ResponseEntity<Elective> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Elective.class);
        System.out.println(response.getBody());
        assertEquals(elective.getElectCode(), response.getBody().getElectCode());
        System.out.println("Added data:" +response);

    }

    @Test
    public void c_update() {

        Elective modify;
        modify = new Elective.Builder()
                .copy(elective)
                .setElectCode("0000120")
                .build();
        String url = baseURL +"modify";
        ResponseEntity<Elective> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, modify, Elective.class);
        assertNotNull(String.valueOf(elective.getElectCode()), responseEntity
                .getBody()
                .getElectCode());
        System.out.println("Modified successfully..." + responseEntity.getBody());


    }


    @Test
    public void delete() {
        String url = baseURL + "delete/" + elective.getElectCode();
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test
    public void getAll() {
        String url = baseURL + "all";
        HttpHeaders hHeader = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, hHeader);
        ResponseEntity<String> rspEn = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(rspEn);
        System.out.println(rspEn.getBody());
    }

}
