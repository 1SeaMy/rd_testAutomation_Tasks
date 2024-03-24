package common;

import driver.DriverFactory;
import pages.ButtonsPage;
import pages.WebTablesPage;

public class PageManager {
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;

    public PageManager() {

        DriverFactory.initDriver();

        webTablesPage = PageFactory.buildWebtablesPage();
        buttonsPage = PageFactory.buildButtonsPage();
    }
}
