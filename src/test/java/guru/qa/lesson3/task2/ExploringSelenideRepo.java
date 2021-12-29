package guru.qa.lesson3.task2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ExploringSelenideRepo {
    /*- Откройте страницу Selenide в Github

     - Перейдите в раздел Wiki проекта

     - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

     - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5*/
    private ExploringSelenideRepo exploringSelenideRepo;

    @BeforeAll
    static void configurateTestRun() {
        //Configuration.browserSize="1920*1080";
        open("https://github.com/");
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void init() {
        exploringSelenideRepo = new ExploringSelenideRepo();
    }

    @Test
    void SelenideRepoContainsJunit5ExampleOnSoftAssertionsPage() {
        exploringSelenideRepo.searchRepo("Selenide");
        exploringSelenideRepo.chooseRepoByName("/selenide/selenide");
        exploringSelenideRepo.goToRepoSection("Wiki");
        exploringSelenideRepo.pagePresenting("SoftAssertions","/selenide/selenide/wiki/SoftAssertions");
        exploringSelenideRepo.textPresentingInsidePage("Junit5");
    }


    void searchRepo(String repoNameToFind) {
        $("[data-test-selector=nav-search-input]")
                .setValue(repoNameToFind)
                .pressEnter();
    }

    private void chooseRepoByName(String repoName) {
        $("a[href=" + "\'" + repoName + "\'" + "]")
                .click();//наверное стоило экранировать '
    }

    void goToRepoSection(String repoSectionName) {
        $("span[data-content=" + "\'" + repoSectionName + "\'" + "]")
                .click();
    }

    void pagePresenting(String pageName,String refName) {
       /* $(".markdown-body").$("[href='/selenide/selenide/wiki/" +
                        "\'"+ pageName+ "\'"+ "]");

        */
        $$("a[class='internal present']").find(Condition.text(pageName));
        $(".markdown-body").$("[href=" +"\'" + refName + "\'"+ "]").click();

    }

    void textPresentingInsidePage(String text) {
        $(".markdown-body").shouldHave(text(text));
    }
}


