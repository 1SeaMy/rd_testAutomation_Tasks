package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage extends BasePage{

    public SelenideElement myButtons = $(".show li:nth-of-type(5) > .text");
    public SelenideElement myClickMe = $(".col-md-6 div:nth-of-type(3) > .btn");

    public ButtonsPage(String pageUrl) {
        super(pageUrl);
    }
}
