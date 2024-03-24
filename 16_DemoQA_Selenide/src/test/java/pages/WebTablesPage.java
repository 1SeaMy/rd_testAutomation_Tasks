package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class WebTablesPage extends BasePage{

    public SelenideElement myWebTables = $(".show li:nth-of-type(4) > .text");
    public SelenideElement myAdd = $("button#addNewRecordButton");
    public SelenideElement myFirstName = $("input#firstName");
    public SelenideElement myLastName = $("input#lastName");
    public SelenideElement myEmail = $("input#userEmail");
    public SelenideElement myAge = $("input#age");
    public SelenideElement mySalary = $("input#salary");
    public SelenideElement myDepartment = $("input#department");
    public SelenideElement mySubmit = $("button#submit");
    public SelenideElement myEdit = $("span#edit-record-4");

    public WebTablesPage(String pageUrl) {
        super(pageUrl);
    }
}
