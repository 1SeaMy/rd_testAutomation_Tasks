package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.List;

public class DemoQA_webtables_CSS {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL_TBL");



    @BeforeClass(alwaysRun = true, groups= {"WebtablesCSS"})
    public void beforeMyTests() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }
    @Test(groups= {"WebtablesCSS"}, priority = 1)
    public void clickAddTest(){
        driver.findElement(new By.ByCssSelector("button#addNewRecordButton")).click();;
    }
    @Test(groups= {"WebtablesCSS"}, priority = 2)
    public void fillFormTest(){
        List<String> inputValues = List.of("ayşe", "can", "ayse@can.com", "35", "50000", "QA");
        List<WebElement> inputs = driver.findElements(By.cssSelector(".mr-sm-2"));
        for (int i = 0; i < Math.min(inputs.size(), inputValues.size()); i++) {
            inputs.get(i).sendKeys(inputValues.get(i));
        }
//        driver.findElement(new By.ByCssSelector("input#firstName")).sendKeys("");
//        driver.findElement(new By.ByCssSelector("input#lastName")).sendKeys("");
//        driver.findElement(new By.ByCssSelector("input#userEmail")).sendKeys("ayse@can.com");
//        driver.findElement(new By.ByCssSelector("input#age")).sendKeys("35");
//        driver.findElement(new By.ByCssSelector("input#salary")).sendKeys("50000");
//        driver.findElement(new By.ByCssSelector("input#department")).sendKeys("QA");
    }
    @Test(groups= {"WebtablesCSS"}, priority = 3, enabled=true)
    public void clickSubmitTest(){
        driver.findElement(new By.ByCssSelector("button#submit")).click();
    }
    @Test(groups= {"WebtablesCSS"}, priority = 4, enabled=true)
    public void clickEditTest(){
        driver.findElement(new By.ByCssSelector("span#edit-record-4")).click();
    }
    @Test(groups= {"WebtablesCSS"}, priority = 5, enabled=true)
    public void editFormTest(){
        driver.findElement(new By.ByCssSelector("input#firstName")).clear();
        driver.findElement(new By.ByCssSelector("input#firstName")).sendKeys("ayşegül");
        driver.findElement(new By.ByCssSelector("input#userEmail")).clear();
        driver.findElement(new By.ByCssSelector("input#userEmail")).sendKeys("aysegul@can.com");
    }
    @Test(groups= {"WebtablesCSS"}, priority = 6, enabled=true)
    public void clickReSubmitTest(){
        driver.findElement(new By.ByCssSelector("button#submit")).click();
    }
    @AfterClass(alwaysRun = true, groups= {"WebtablesCSS"}, enabled=true)
    public void afterMyTests()  {
        webDriver.quitDriver();
    }
}
