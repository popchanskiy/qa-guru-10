package guru.qa.lesson5.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class DataPickerComponent {
    protected boolean calendarStatus;

    private boolean isCalendarActive() {
        return $("#dateOfBirthInput.form-control.react-datepicker-ignore-onclickoutside")
                .isDisplayed();
    }

    private void activateCalendar() {
        if (!isCalendarActive()) {
            $("#dateOfBirthInput").click();
        }
    }

    public void setDate(String day, String month, String year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public DataPickerComponent setDay(String day) {
        String zeroesAmount = "00";
        if(Integer.valueOf(day).intValue()/10>=1){ //
            zeroesAmount="0";
        }
        activateCalendar();

        String dayLocator = format(".react-datepicker__day--"+ zeroesAmount +"%s:not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();
        return this;
    }

    public DataPickerComponent setMonth(String month) {
        activateCalendar();
        $(".react-datepicker__month-select")
                .selectOption(month);
        return this;

    }

    public DataPickerComponent setYear(String year) {
        activateCalendar();
        $(".react-datepicker__year-select")
                .selectOption(year);
        return this;
    }


}
