package guru.qa.lesson5.pages.forms.practice_form_page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubmittingReportPage  {
    private SelenideElement modalPage = $("#example-modal-sizes-title-lg");

    public SubmittingReportPage pageShouldBe(Condition condition) {
        modalPage.shouldBe(condition);
        return this;
    }


        public SubmittingReportPage tableShouldHaveTexts(String... exactTexts) {
            $$(".table td:last-child").shouldHave(exactTexts(exactTexts));
            return this;
    }
}
