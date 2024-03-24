package tests;

import com.codeborne.selenide.Selenide;
import driver.DriverFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import common.PageManager;

public class BaseTests {
    protected PageManager pageManager;
    protected SoftAssert softAssert;
    @BeforeClass (alwaysRun=true,groups={"First"})
    public void setUp() {
        pageManager = new PageManager();
        softAssert = new SoftAssert();
    }
    @BeforeMethod (alwaysRun=true,groups={"First"})
    public void openDriver() {
        Selenide.open();
    }

    @AfterMethod (alwaysRun=true,groups={"Last"})
    public void clearCookies() {
        DriverFactory.clearCookies();
    }

    @AfterClass (alwaysRun=true,groups={"Last"})
    public void tearDown() {
        DriverFactory.close();
    }
}
