package guru.qa.lesson6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;

public class CheckIssueWithSteps {
    @Step("открываем гитхаб")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("ищем репозиторий {repository}")
    public void searchForRepository(String repository){
        $("[data-test-selector='nav-search-input']").setValue(repository).pressEnter();
    }

    @Step("открываем найденный репозиторий {repository}")
    public void openRepositoryPage(String repository) {
        $$("ul.repo-list li").first().$("a").click();
    }

    @Step("ищем вкладку 'Issues'")
    public void searchIssuesTab(){
        attachPageSource();
        $("#issues-tab").should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }
}
