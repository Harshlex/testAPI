package org.perevall;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
//import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ApiTest {
    @Test()
    public static void checkGetUsers() throws Exception {

        Response response = given().relaxedHTTPSValidation().contentType("application/json")
                .when()
                .get("https://gorest.co.in/public/v1/users/33");
        Assert.assertEquals(response.getStatusCode(),200);
        //Assert.assertEquals(response.);
        System.out.print(response);

    }
    @Test
    public static void checkCreateUsers() throws Exception {
        String body = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"t@15ce.com\", \"status\":\"active\"}";
        Response response = given().relaxedHTTPSValidation().contentType("application/json").header("Authorization", "Bearer " + "41afda39c1b9f9862585a8ca759f5548a74b242ee50676cdec3b0c8cf26d6df0").body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
        String respons = response.asString();
        Assert.assertEquals(response.getStatusCode(),201);
    }
}

    @Test
    