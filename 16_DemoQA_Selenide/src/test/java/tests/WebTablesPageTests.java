package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class WebTablesPageTests extends BaseTests {

    @BeforeMethod (alwaysRun=true,groups={"WebTablesPage"})
    public void before(){
        pageManager.buttonsPage.open();
    }

    @Test (alwaysRun=true,groups={"WebTablesPage"})
    public void addEditData(){
        pageManager.webTablesPage.myWebTables.click();
        pageManager.webTablesPage.myAdd.click();
        pageManager.webTablesPage.myFirstName.setValue("ayşe");
        pageManager.webTablesPage.myLastName.setValue("can");
        pageManager.webTablesPage.myEmail.setValue("ayse@can.com");
        pageManager.webTablesPage.myAge.setValue("35");
        pageManager.webTablesPage.mySalary.setValue("50000");
        pageManager.webTablesPage.myDepartment.setValue("QA");
        pageManager.webTablesPage.mySubmit.click();
        sleep(2*1000);
        pageManager.webTablesPage.myEdit.click();
        pageManager.webTablesPage.myFirstName.setValue("ayşegül");
        pageManager.webTablesPage.myEmail.setValue("aysegul@can.com");
        pageManager.webTablesPage.mySubmit.click();
        sleep(3*1000);
    }
}
