package guru.qa.lesson8.pages.starter_page.page_components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    private SelenideElement table = $("table");
    private SelenideElement recordingAmount = $("div.content > p");
    //private ElementsCollection tableColumnList = $$("table thead tr");

    private SelenideElement getTableValues() {
        return $("table tbody.ajax_load_row");
    }

    public ResultTable checkResultRowsQuantity(int expectedRowsAmount) {
        ElementsCollection rows = getTableValues().$$("tr");
        rows.shouldHave(size(expectedRowsAmount));
        return this;
    }

    public ResultTable checkEmailValuePresent(String expectedEmail) {
        ElementsCollection rows = getTableValues().$$("tr td:nth-child(1)");
        SelenideElement element = rows.find(Condition.text(expectedEmail));
        element.shouldHave(Condition.text(expectedEmail));
        return this;
    }

    public ResultTable checkNameValuePresent(String name) {
        ElementsCollection rows = getTableValues().$$("tr td:nth-child(2)");
        SelenideElement element = rows.find(Condition.text(name));
        element.shouldHave(Condition.text(name));
        return this;
    }
}
