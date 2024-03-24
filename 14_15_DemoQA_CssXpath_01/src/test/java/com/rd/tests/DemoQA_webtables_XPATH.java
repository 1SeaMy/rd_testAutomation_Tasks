package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;

public class DemoQA_webtables_XPATH {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL_TBL");



    @BeforeClass(alwaysRun = true, groups= {"WebtablesXPATH"})
    public void beforeMyTests() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 1)
    public void clickAddTest(){
        driver.findElement(new By.ByXPath("//button[@id='addNewRecordButton']")).click();
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 2)
    public void fillFormTest(){
        List<String> inputValues = List.of("ayşe", "can", "ayse@can.com", "35", "50000", "QA");
        String[] xpaths = {
                "//input[@id='firstName']",
                "//input[@id='lastName']",
                "//input[@id='userEmail']",
                "//input[@id='age']",
                "//input[@id='salary']",
                "//input[@id='department']"
        };
        for (int i = 0; i < Math.min(xpaths.length, inputValues.size()); i++) {
            WebElement input = driver.findElement(By.xpath(xpaths[i]));
            input.sendKeys(inputValues.get(i));
        }
//        driver.findElement(new By.ByXPath("//input[@id='firstName']")).sendKeys("ayşe");
//        driver.findElement(new By.ByXPath("//input[@id='lastName']")).sendKeys("can");
//        driver.findElement(new By.ByXPath("//input[@id='userEmail']")).sendKeys("ayse@can.com");
//        driver.findElement(new By.ByXPath("//input[@id='age']")).sendKeys("35");
//        driver.findElement(new By.ByXPath("//input[@id='salary']")).sendKeys("50000");
//        driver.findElement(new By.ByXPath("//input[@id='department']")).sendKeys("QA");
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 3, enabled=true)
    public void clickSubmitTest(){

        driver.findElement(new By.ByXPath("//button[@id='submit']")).click();
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 4, enabled=true)
    public void clickEditTest(){
        driver.findElement(new By.ByXPath("//span[@id='edit-record-4']")).click();
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 5, enabled=true)
    public void editFormTest(){
        driver.findElement(new By.ByXPath("//input[@id='firstName']")).clear();
        driver.findElement(new By.ByXPath("//input[@id='firstName']")).sendKeys("ayşegül");
        driver.findElement(new By.ByXPath("//input[@id='userEmail']")).clear();
        driver.findElement(new By.ByXPath("//input[@id='userEmail']")).sendKeys("aysegul@can.com");
    }
    @Test(groups= {"WebtablesXPATH"}, priority = 6, enabled=true)
    public void clickReSubmitTest(){
        driver.findElement(new By.ByXPath("//button[@id='submit']")).click();
    }
    @AfterClass(alwaysRun = true, groups= {"WebtablesXPATH"}, enabled=true)
    public void afterMyTests()  {
        webDriver.quitDriver();
    }
}
