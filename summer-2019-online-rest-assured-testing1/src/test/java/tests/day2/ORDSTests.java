package tests.day2;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static  org.junit.jupiter.api.Assertions.*;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
public class ORDSTests {
    private String baseURI ="http://ec2-3-93-10-103.compute-1.amazonaws.com:1000/ords/hr";
    @Test
    public void test(){
        Response  response =given().get(baseURI+"/employees");
        //  System.out.println(response.getBody().asString());
        assertEquals(200,response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void test2(){
        Response response=given().get(baseURI+"/employees/100");
        System.out.println(response.prettyPrint());
        assertEquals(200,response.getStatusCode());
    }
    @Test
    public void test3(){
        Response response = given(). get(baseURI+"/regions");
        assertEquals(200, response.getStatusCode());
        Header header = response.getHeaders().get("Content-Type");
        for(Header h: response.getHeaders()) {
            System.out.println(h);
        }

        System.out.println(response.prettyPrint());
    }


}
