package common;

import pages.ButtonsPage;
import pages.WebTablesPage;

public class PageFactory {

    public static WebTablesPage buildWebtablesPage() {
        return new WebTablesPage("/webtables");
    }
    public static ButtonsPage buildButtonsPage() {
        return new ButtonsPage("/buttons");
    }

}

