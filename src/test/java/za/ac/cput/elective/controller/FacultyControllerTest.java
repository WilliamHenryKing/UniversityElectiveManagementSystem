package za.ac.cput.elective.controller;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Faculty;
import za.ac.cput.elective.factory.FacultyFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class FacultyControllerTest {

    private static Faculty facu = FacultyFactory.addFaculty("1234", "ENgineeering");

    @Autowired
    private TestRestTemplate tRestTemp;
    private String baseURL = "http://localhost:8080/faculty/";

    @Test
    public void a_create() {

        ResponseEntity<Faculty> postResponse = tRestTemp.postForEntity(baseURL + "create", facu,
                Faculty.class);

        int num = Integer.parseInt(facu.getFacultyID());
        Assert.assertTrue(num <= 9999);
        Assert.assertNotNull(postResponse.getBody());

        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_show() {

        ResponseEntity<Faculty> getResponse = tRestTemp.getForEntity(baseURL + "show/" + facu.getFacultyID(),
                Faculty.class);

        assertEquals(facu.getFacultyID(), getResponse.getBody().getFacultyID());
        System.out.println(getResponse.getBody());

    }

    @Test
    public void c_change() {

        String old = facu.getFacultyName();
        Faculty changed = new Faculty.Builder().copy(facu).setFacultyName("Engineering").build();
        ResponseEntity<Faculty> changedResponse = tRestTemp.postForEntity(baseURL + "change", facu,
                Faculty.class);
        assertNotEquals(old, changedResponse.getBody().getFacultyID());
        System.out.println("Changed: " + changed);

    }

    @Test
    public void d_showAll() {
        /**
        // struggled to find another way to show all using SpringBootTest

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> hEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> exchangeResponse = tRestTemp.exchange(baseURL + "all", HttpMethod.GET, hEntity,
                String.class);

        System.out.println(exchangeResponse);
        System.out.println(exchangeResponse.getBody());
        */

        ResponseEntity<Faculty> getResponse = tRestTemp.getForEntity(baseURL + "showAll/" + facu.getFacultyID(),
                Faculty.class);

        assertEquals(facu.getFacultyID(), getResponse.getBody().getFacultyID());
        System.out.println(getResponse.getBody());

    }

    @Test
    public void e_delete() {
        tRestTemp.delete(baseURL + "delete/" + facu.getFacultyID());
        System.out.println(facu.getFacultyID() +  ", " + facu.getFacultyName());
    }
}