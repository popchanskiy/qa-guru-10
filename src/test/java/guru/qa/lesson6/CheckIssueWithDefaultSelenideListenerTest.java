package guru.qa.lesson6;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.*;
import io.qameta.allure.*;
import io.qameta.allure.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class CheckIssueWithDefaultSelenideListenerTest {
    @Test
    @Owner("popchanskiy")
    @Feature("Issues")
    @Story("Проверка наличия вкладки Issues")
    @DisplayName("Проверка наличия вкладки Issues с листенером")
    public void testIssuesSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $("[data-test-selector='nav-search-input']").setValue("popchanskiy/qa-guru-10").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").should(Condition.visible);
    }
}
