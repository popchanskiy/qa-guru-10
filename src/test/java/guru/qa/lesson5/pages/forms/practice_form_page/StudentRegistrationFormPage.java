package guru.qa.lesson5.pages.forms.practice_form_page;

import com.codeborne.selenide.SelenideElement;
import guru.qa.lesson5.pages.BasePage;
import guru.qa.lesson5.pages.components.DataPickerComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage extends BasePage {
    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement genderRadioBtn = $("#genterWrapper");
    private final SelenideElement mobileField = $("#userNumber");
    //private final SelenideElement dateOfBirthField = $("#dateOfBirthInput");
    private final SelenideElement subjectsField = $("#subjectsInput");
    //private final SelenideElement hobbiesRadioBtn = $(byText(String.valueOf("")));
    private final SelenideElement pictureUploadField = $("#uploadPicture");
    private final SelenideElement addressField = $("#currentAddress");
    private final SelenideElement stateSelect = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-4-input");
    private final SelenideElement submitBtn= $("#submit");


    public StudentRegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
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
        genderRadioBtn.$(byText(gender)).click();
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

    public StudentRegistrationFormPage setSubject(String subject) {
        subjectsField
                .setValue(subject)
                .pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setHobbies(String hobbies) {
        $(byText(String.valueOf(hobbies))).click();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture(String filePath) {
        pictureUploadField.uploadFromClasspath(filePath);
        return this;
    }

    public StudentRegistrationFormPage setAddress(String address) {
        addressField.setValue(address);
        return this;
    }

    public StudentRegistrationFormPage selectState(String state) {
        stateSelect.setValue(String.valueOf(state))
                .pressEnter();
        return this;
    }

    public StudentRegistrationFormPage selectCity(String city) {
        citySelect.setValue(String.valueOf(city))
                .pressEnter();
        return this;
    }
    public void submitBtnClick() {
        submitBtn
                .scrollIntoView(true)
                .click();
    }

}
