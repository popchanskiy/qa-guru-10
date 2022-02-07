package guru.qa.lesson8.pages.starter_page.page_components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainMenuBtns {
    private SelenideElement btnSearch = $("td > input[placeholder]");
    private SelenideElement btnLogin = $("#main-menu li:nth-child(2) a span");

    public MainMenuBtns btnLoginShouldBe(Condition condition) {
        btnLogin.shouldBe(Condition.exist);
        return this;
    }


}
