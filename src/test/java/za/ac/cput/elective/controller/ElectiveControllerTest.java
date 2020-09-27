package za.ac.cput.elective.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.elective.entity.Elective;
import za.ac.cput.elective.factory.ElectiveFactory;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElectiveControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String baseURL = "http://localhost:8080/elective/";


    @Test
    public void create() {
        Elective elect  = ElectiveFactory.createElective("Scala", "Mathematical Coding");
        ResponseEntity<Elective> postResponse = restTemplate.postForEntity
                      (baseURL + "/create", elect, Elective.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    //READ METHOD

    @Test
    public void update(){
        String electName = "Data Structures";
        String electDesc = "I have no clue what it is about!!!";
        Elective elect = restTemplate.getForObject( baseURL + "/elect/"
                + electName + electDesc, Elective.class );
        Elective updatedElective = restTemplate.getForObject( baseURL + "/elect/"
                + electName + electDesc, Elective.class );
        assertNotNull( updatedElective );
    }

    public void delete() {
        String electName = "Data Structures";
        String electDesc = "I have no clue what it is about!!!";
        Elective elect = restTemplate.getForObject(baseURL + "/elective/" + electName + electDesc, Elective.class);
        assertNotNull(elect);
        restTemplate.delete(baseURL + "/elective/" + electName + electDesc);
        try {
            elect = restTemplate.getForObject(baseURL + "/elective/" + electName + electDesc, Elective.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange
                (baseURL + "/read/all", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());

 }

}//END OF CONTROLLER TEST CLASS!!!