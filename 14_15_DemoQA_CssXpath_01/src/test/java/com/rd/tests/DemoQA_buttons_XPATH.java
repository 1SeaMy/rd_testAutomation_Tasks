package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DemoQA_buttons_XPATH {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL_ELE");

    @BeforeClass(alwaysRun = true, groups= {"ButtonsXPATH"})
    public void beforeMyTests() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }
    @Test(groups= {"ButtonsXPATH"}, priority = 1)
    public void clickButtonsTest(){
        driver.findElement(new By.ByXPath("//li[.='Buttons']")).click();
    }
    @Test(groups= {"ButtonsXPATH"}, priority = 2)
    public void clickClickMeButtonTest() {
        driver.findElement(new By.ByXPath("//button[.='Click Me']")).click();
    }
    @Test(groups= {"ButtonsXPATH"}, priority = 3)
    public void getMessageTest() {
        WebElement myMessage = driver.findElement(new By.ByXPath("//p[@id='dynamicClickMessage']"));
        Assert.assertEquals(myMessage.getText(),"You have done a dynamic click");
        System.out.println(myMessage.getText());
    }
    @AfterClass(alwaysRun = true, groups= {"ButtonsXPATH"})
    public void  afterMyTests(){
        webDriver.quitDriver();
    }
}