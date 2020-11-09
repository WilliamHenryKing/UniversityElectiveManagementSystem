package za.ac.cput.elective.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.elective.entity.Admin;
import za.ac.cput.elective.factory.AdminFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AdminControllerTest {
    private static String userName ="admin";
    private static String secPassWord = "psw";

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String baseURL = "http://localhost:8080/admin/";
    private static Admin ad = AdminFactory.buildAdmin("2", "Simba");

    @Test
    public void create() {
        String url = baseURL + "create";
        ResponseEntity<Admin> a = restTemplate.withBasicAuth(userName,secPassWord).postForEntity(url, ad, Admin.class);

        assertNotNull(ad);
        assertNotNull(a.getBody());
        System.out.println(a.getBody());
    }

    @Test
    public void read() {
        String url = baseURL + "read/" + ad.getAdminID();
        ResponseEntity<Admin> re = restTemplate.withBasicAuth(userName,secPassWord).getForEntity(url, Admin.class);
        assertEquals(ad.getAdminID(), re.getBody().getAdminID());
    }

    @Test
    public void update() {
        Admin up = new Admin.AdminBuilder().copy(ad).setAdminID("5").build();
        String url = baseURL + "update";
        ResponseEntity<Admin> ren = restTemplate.withBasicAuth(userName,secPassWord).postForEntity(url, up, Admin.class);
        assertEquals(ad.getAdminID(), ren.getBody().getAdminID());
    }

    @Test
    public void delete() {
        String url = baseURL + "delete/" + ad.getAdminID();
        restTemplate.withBasicAuth(userName,secPassWord).delete(url);
    }

    @Test
    public void getAll() {
        String url = baseURL + "all";
        HttpHeaders h = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, h);
        ResponseEntity<String> ren = restTemplate.withBasicAuth(userName,secPassWord).exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(ren);
        System.out.println(ren.getBody());
    }
}