package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DemoQA_buttons_CSS {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL_ELE");

    @BeforeClass(alwaysRun = true, groups= {"ButtonsCSS"})
    public void beforeMyTests() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }
    @Test(groups= {"ButtonsCSS"}, priority = 1)
    public void clickButtonsTest(){
        driver.findElement(By.cssSelector(".show li:nth-of-type(5) > .text")).click();
    }
    @Test(groups= {"ButtonsCSS"}, priority = 2)
    public void clickClickMeButtonTest() {
        driver.findElement(By.cssSelector(".col-md-6 div:nth-of-type(3) > .btn")).click();
    }
    @Test(groups= {"ButtonsCSS"}, priority = 3)
    public void getMessageTest() {
        WebElement myMessage = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        Assert.assertEquals(myMessage.getText(),"You have done a dynamic click");
        System.out.println(myMessage.getText());
    }
    @AfterClass(alwaysRun = true, groups= {"ButtonsCSS"})
    public void  afterMyTests(){
        webDriver.quitDriver();
    }
}