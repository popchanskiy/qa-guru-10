package guru.qa.lesson2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {


    @Test
    @DisplayName("HappyPathTest")
    void TestStudentRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1998");
        $x("//div[contains(text(),'25')]").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(text(),'Sport')]").click();
        $("#uploadPicture").uploadFromClasspath("file.txt");
        $("#submit").scrollTo();
        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("Ha").pressEnter();
        $("#react-select-4-input").setValue("Pa").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table-responsive").shouldHave(text("Alex"), text("Ivanov"), text("ivanov@gmail.com"),
                text("Male"), text("7999999999"), text("25 March,1998"), text("Moscow"), text("English"),
                text("Sports"), text("file.txt"), text("Haryana Panipat"));
    }
}
