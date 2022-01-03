package guru.qa.lesson5.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.lesson5.pages.forms.practice_form_page.StudentRegistrationFormPage;
import guru.qa.lesson5.pages.forms.practice_form_page.SubmittingReportPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    StudentRegistrationFormPage automationPracticeForm= new StudentRegistrationFormPage();
    SubmittingReportPage submittingReportPage=new SubmittingReportPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.headless = false;
    }
}
