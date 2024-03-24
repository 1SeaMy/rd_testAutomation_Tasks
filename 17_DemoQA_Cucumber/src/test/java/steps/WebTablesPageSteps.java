package steps;

import java.io.FileReader;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import io.cucumber.datatable.DataTable;
import common.PageManager;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import io.cucumber.java.en.But;
import utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTablesPageSteps {
    PageManager pageManager = new PageManager();
    CommonSteps commonSteps = new CommonSteps();
    ScenarioContext scenarioContext = new ScenarioContext();

    @When("Enter {string},{string},{string},{},{},{string} fields")
    public void enterFields(String firstName, String lastName, String email, int age, int salary, String department) {
        pageManager.webTablesPage.fill_registration_form(firstName, lastName, email, age, salary, department);
    }

    @Then("Check fourth Record")
    public void checkFourthRecord() {
        assertThat(pageManager.webTablesPage.myEdit.isDisplayed()).isTrue();
    }

    @But("fix Registration Form from table")
    public void fixRegistrationFormFromTable(DataTable dataTable) {
        String firstName = null;
        String email = null;
        List<Map<String, String>> data = Collections.singletonList(dataTable.asMap());
        for (Map<String, String> form : data) {
            firstName = form.get("firstName");
            email = form.get("email");
        }
        pageManager.webTablesPage.fix_registration_form(firstName, email);
    }

    @When("Get data from file and fill form")
    public void getDataFromFileAndFillForm() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> formRecords = mapper.readValue(new FileReader("src/test/resources/datas/formRecords.json"), List.class);
        for (Map<String, String> formRecord : formRecords) {
            commonSteps.click_button("Add");
            pageManager.webTablesPage.fill_registration_form(formRecord.get("firstName"), formRecord.get("lastName"), formRecord.get("email"), Integer.parseInt(formRecord.get("age")), Integer.parseInt(formRecord.get("salary")), formRecord.get("department"));
            commonSteps.click_button("Submit");
        }
    }
}
