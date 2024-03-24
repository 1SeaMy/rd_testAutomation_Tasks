package steps;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import common.PageManager;
import io.cucumber.java.en.*;

public class CommonSteps {
    PageManager pageManager = new PageManager();

    @Given("open {string} page")
    public void open_page(String string) {
        open(string);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Then("wait {int} seconds")
    public void wait_seconds(Integer int1) {
        sleep(int1 * 1000);
    }

    @When("click {string} button")
    public void click_button(String string) {
        //üst
        switch (string) {
            case "Buttons" -> pageManager.buttonsPage.myButtons.click();
            case "Click Me" -> pageManager.buttonsPage.myClickMe.click();
            case "WebTables" -> pageManager.webTablesPage.myWebTables.click();
            case "Add" -> pageManager.webTablesPage.myAdd.click();
            case "Submit" -> pageManager.webTablesPage.mySubmit.click();
            case "Edit" -> pageManager.webTablesPage.myEdit.click();
            default -> {
            }
        }
    }

}