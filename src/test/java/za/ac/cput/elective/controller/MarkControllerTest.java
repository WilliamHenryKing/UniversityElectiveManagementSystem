package za.ac.cput.elective.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Mark;
import za.ac.cput.elective.factory.MarkFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

class MarkControllerTest
{
    private static Mark m = MarkFactory.createMark("001");
    private static String SECURITY_USERNAME = "doozy";
    private static String SECURITY_PASSWORD = "doozy1";

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String baseURL = "http://localhost:8080/mark";



    @Test
    void create()
    {
        Mark mark = MarkFactory.createMark("001");
        String url = baseURL + "create";
        ResponseEntity<Mark> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, mark, Mark.class );
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }

    @Test
    void read()
    {
        String url = baseURL + "read/" + m.getMarksID();
        ResponseEntity<Mark> re = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Mark.class);
        assertEquals(m.getMarksID(), re.getBody().getMarksID());
    }

    @Test
    void update()
    {
        Mark mark = new Mark.Builder().copy(m).setMarksID("001").build();
        String url = baseURL + "update";
        ResponseEntity<Mark> re = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, mark, Mark.class);
        assertEquals(m.getMarksID(), re.getBody().getMarksID());
    }

    @Test
    void getAll()
    {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>( null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void delete()
    {
        String url = baseURL + "delete/" + m.getMarksID();
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }
}