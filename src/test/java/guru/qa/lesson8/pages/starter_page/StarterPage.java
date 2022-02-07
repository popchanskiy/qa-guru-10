package guru.qa.lesson8.pages.starter_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.lesson8.pages.starter_page.page_components.MainMenuBtns;
import guru.qa.lesson8.pages.starter_page.page_components.ResultTable;
import guru.qa.lesson8.pages.starter_page.page_components.SearchBar;

import static com.codeborne.selenide.Selenide.$;

public class StarterPage {
    private SelenideElement table = $("table");
    private SelenideElement pageHeader = $("p");

    public StarterPage openPage() {
        Selenide.open("http://users.bugred.ru/");
        table.shouldBe(Condition.exist);
        pageHeader.shouldHave(Condition.text("  " +
                "— бесплатный тестовый проект с багами и методами SOAP / REST. "));
        return this;
    }

    public MainMenuBtns checkMainMenuBtns() {
        return new MainMenuBtns();
    }

    public ResultTable checkResultTable() {
        return new ResultTable();
    }

    public SearchBar checkSearch() {
        return new SearchBar();
    }


}
