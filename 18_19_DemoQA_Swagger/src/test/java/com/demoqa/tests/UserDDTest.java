package com.demoqa.tests;

import com.demoqa.services.UserLogin;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

@Epic("User Management")
@Feature("User Operations")
public class UserDDTest extends UserLogin {
    @Test (groups = "User credentials")
    @Description("Check User Test")
    @Severity(SeverityLevel.MINOR)
    public void checkUserTest (){
        Response response = createOrCheckUser("seamy02", "Example@123");

        Assert.assertEquals("1204", response.jsonPath().getJsonObject("code"));
        Assert.assertEquals("User exists!", response.jsonPath().getJsonObject("message"));
    }

    @Test (groups = "User credentials")
    @Description("Create User Test")
    @Severity(SeverityLevel.MINOR)
    public void createUserTest (){
        Response response = createOrCheckUser("seamy03", "Example@123");

        Assert.assertNotNull(response.jsonPath().getJsonObject("userID"));
        Assert.assertNotNull(response.jsonPath().getJsonObject("username"));
    }
}
