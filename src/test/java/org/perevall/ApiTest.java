package org.perevall;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import static afu.org.checkerframework.checker.units.UnitsTools.s;
import static io.restassured.RestAssured.*;

public class ApiTest {
    public static String getRandomNumber(int n) {
        StringBuilder number = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            number.append(random.nextInt(8) + 1);
        }
        return number.toString();
    }

    @Test()
    public static void checkGetUsers() throws Exception {

        Response response = given().
                relaxedHTTPSValidation().
                contentType("application/json").
                when().
                get("https://gorest.co.in/public/v1/users/1987");
        Assert.assertEquals(response.getStatusCode(), 200);
        //Assert.assertEquals(response.);
        System.out.print(response);

    }

    @Test()
    public static void checkCreateUsers() throws Exception {
        String email = getRandomNumber(5) + "@as.com";
        String body = "{\"name\":\"Don DigiDon\", \"gender\":\"male\", \"email\": \"" + email + "\", \"status\":\"active\"}";
        Response response = given().
                relaxedHTTPSValidation().
                contentType("application/json").
                header("Authorization", "Bearer " + "972514330f4f728bb6c3956cd01a060fd60f826cfca6adf4a0c4a6425d4e51ef").
                body(body).
                when().
                post("https://gorest.co.in/public/v1/users");
        String respons = response.asString();
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.print(respons);
        String id = (String) jsonObject.get("id");
    }

    @Test()
    public static void checkDeleteUsers() throws Exception {
        Response response = given().relaxedHTTPSValidation().contentType("application/json").header("Authorization",
                        "Bearer " + "972514330f4f728bb6c3956cd01a060fd60f826cfca6adf4a0c4a6425d4e51ef")
                .when()
                .delete("https://gorest.co.in/public/v1/users/1587");
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.print(response);
    }

    public static String createUser(){
        String email = getRandomNumber(5) + "@as.com";
        String body = "{\"name\":\"Don DigiDon\", \"gender\":\"male\", \"email\": \"" + email + "\", \"status\":\"active\"}";
        Response response = given().
                relaxedHTTPSValidation().
                contentType("application/json").
                header("Authorization", "Bearer " + "972514330f4f728bb6c3956cd01a060fd60f826cfca6adf4a0c4a6425d4e51ef").
                body(body).
                when().
                post("https://gorest.co.in/public/v1/users");
        String respons = response.asString();
        String id =
        return id;
    }
}

