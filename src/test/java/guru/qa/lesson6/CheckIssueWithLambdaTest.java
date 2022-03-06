package guru.qa.lesson6;

import com.codeborne.selenide.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckIssueWithLambdaTest {
    private static final String REPOSITORY = "popchanskiy";

    @Test
    @Owner("popchanskiy")
    @Feature("Issues")
    @Story("Проверка наличия вкладки Issues")
    @DisplayName("Проверка наличия вкладки Issues с лямбда шагами")
    @Severity(SeverityLevel.BLOCKER)
    public void lambdaStepTest(){
        step("открываем гитхаб", () -> {
            open("https://github.com");
        });

        step("ищем репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
        });

        step("открываем найденный репозиторий", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });

        step("ищем вкладку 'Issues'", () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $("#issues-tab").should(Condition.visible);
        });

    }


    @Test
    @Owner("popchanskiy")
    @Feature("Issues")
    @Story("Проверка наличия вкладки Issues")
    @DisplayName("Проверка наличия вкладки Issues с аннотацией @Step")
    public void annotatedStepsTest() {
      CheckIssueWithSteps steps = new CheckIssueWithSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.searchIssuesTab();
    }
}
