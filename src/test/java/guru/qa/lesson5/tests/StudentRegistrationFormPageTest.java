package guru.qa.lesson5.tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import guru.qa.lesson5.data_generator.FakeDataGenerator;
import guru.qa.lesson5.pages.forms.practice_form_page.StudentRegistrationFormPage;
import guru.qa.lesson5.pages.forms.practice_form_page.SubmittingReportPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

public class StudentRegistrationFormPageTest extends BaseTest {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String address = faker.address().fullAddress();
    String phoneNumber = faker.number().digits(10);
    @Test
    void regFormShouldBeSubmittedAndVerified(){
        automationPracticeForm
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setMobile(phoneNumber)
                .setDate("1","March","1998")
                .setSubject("English")
                .setSubject("Hindi")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .uploadPicture("file.txt")
                .setAddress(address)
                .selectState("Haryana")
                .selectCity("Panipat")
                .submitBtnClick();
        submittingReportPage
                .pageShouldBe(visible)
                .tableShouldHaveTexts(firstName + " " + lastName,email,"Male",phoneNumber,"01 March,1998",
                        "English, Hindi","Sports, Reading","file.txt",address,"Haryana Panipat");

    }
}
