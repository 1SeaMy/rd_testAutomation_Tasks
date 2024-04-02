package com.demoqa.services;

import com.demoqa.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserLogin extends BaseTest{

    protected Response createOrCheckUser (String userName, String password) {
        User userBody= new User(userName, password);
        Response response = given(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(userBody)
                .post("/Account/v1/User");
        return response;
    }
}
