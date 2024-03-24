package steps;

import common.PageManager;
import utils.Context;
import utils.ScenarioContext;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.*;

public class ButtonsPageSteps {
    PageManager pageManager = new PageManager();
    ScenarioContext scenarioContext = new ScenarioContext();

    @Then("check dynamic Click Message {string}")
    public void checkDynamicClickMessage(String message) {
        scenarioContext.setContext(Context.ID, message);
    }
    @Then("check dynamic Click Message")
    public void check_dynamic_click_message() {
        String sharedMessage=scenarioContext.getContext(Context.ID).toString();
        pageManager.buttonsPage.myDynamicClickMessage.shouldHave(text(sharedMessage));
    }
}