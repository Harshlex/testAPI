package org.perevall;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static afu.org.checkerframework.checker.units.UnitsTools.s;
import static io.restassured.RestAssured.*;

public class ApiTest {

    @Test()
    public static void checkGetUsers() throws Exception {

        Response response = given().relaxedHTTPSValidation().contentType("application/json")
                .when()
                .get("https://gorest.co.in/public/v1/users/1987");
        Assert.assertEquals(response.getStatusCode(),200);
        //Assert.assertEquals(response.);
        System.out.print(response);
    }
    @Test()
    public static void checkCreateUsers() throws Exception {
        String email = ((int) (Math.random()* 10000)) + "@as.com";
        System.out.print(email);
        String body = "{\"name\":\"Don DigiDon\", \"gender\":\"male\", \"email\":\"asas@as.com\", \"status\":\"active\"}";
        Response response = given().relaxedHTTPSValidation().contentType("application/json").header("Authorization", "Bearer " + "972514330f4f728bb6c3956cd01a060fd60f826cfca6adf4a0c4a6425d4e51ef").body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
        String respons = response.asString();
        Assert.assertEquals(response.getStatusCode(),201);
        System.out.print(respons);
    }
    @Test()
    public static void checkDeleteUsers() throws Exception{
        Response response = given().relaxedHTTPSValidation().contentType("application/json").header("Authorization", "Bearer " + "972514330f4f728bb6c3956cd01a060fd60f826cfca6adf4a0c4a6425d4e51ef")
                .when()
                .delete("https://gorest.co.in/public/v1/users/1987");
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.print(response);
    }
}

