package guru.qa.lesson8.pages.starter_page.page_components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchBar {
    private SelenideElement input = submitBtn = $("body > div.content > form > table > tbody > tr:nth-child(4) > td > input");//$(shadowCss("",""));
    private SelenideElement submitBtn = $("button[type='submit']");


    public SearchBar searchEmailWithEnter(String email) {
        input.setValue(email).pressEnter();
        return this;
    }

    public SearchBar searchNameWithClick(String secName) {
        input.setValue(secName).pressEnter();

        return this;
    }

    public SearchBar searchBySecondNameWithEnter(String secName) {
        input.setValue(secName);
        submitBtn.click();
        return this;
    }

}

