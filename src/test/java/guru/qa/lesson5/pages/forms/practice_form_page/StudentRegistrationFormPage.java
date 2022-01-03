package guru.qa.lesson5.pages.forms.practice_form_page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.lesson5.pages.BasePage;
import guru.qa.lesson5.pages.components.DataPickerComponent;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class StudentRegistrationFormPage extends BasePage {
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement genderField = $("#genterWrapper");
    private final SelenideElement mobileField = $("#userNumber");
    private final SelenideElement dateOfBirthField = $("#dateOfBirthInput");
    private final SelenideElement subjectsField = $("#subjectsInput").setValue("English").pressEnter();
    private final SelenideElement hobbies = $x("//label[contains(text(),'Sport')]");
    private final WebElement pictureUploadField = $("#uploadPicture");
    private final SelenideElement addressField = $("#currentAddress");

    public SelenideElement getDateOfBirthField() {
        return dateOfBirthField;
    }

    public StudentRegistrationFormPage setFirstName(String value) {
        firstNameField.setValue(value);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public StudentRegistrationFormPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public StudentRegistrationFormPage setGender(String gender) {
        genderField.$(byText(gender)).click();
        return this;
    }

    public StudentRegistrationFormPage setMobile(String mobile) {
        mobileField.setValue(mobile);
        return this;
    }

    public StudentRegistrationFormPage setDate(String day, String month, String year) {
        new DataPickerComponent().setDate(day, month, year);
        return this;
    }


}
