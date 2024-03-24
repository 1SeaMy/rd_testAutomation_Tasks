package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ButtonsPageTests extends BaseTests {

    @BeforeMethod (alwaysRun=true,groups={"ButtonsPage"})
    public void before(){
        pageManager.buttonsPage.open();
    }

    @Test (alwaysRun=true,groups={"ButtonsPage"})
    public void clickDynamicButton(){
        pageManager.buttonsPage.myButtons.click();
        pageManager.buttonsPage.myClickMe.click();;
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
        sleep(3*1000);
    }
}
