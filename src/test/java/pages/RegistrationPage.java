package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistationResultsModal;

import java.io.File;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistationResultsModal registationResultsModal = new RegistationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            namePage = $(".practice-form-wrapper"),
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            emailInput = $("[id=userEmail]"),
            genderMaleRadiobutton = $("[id=gender-radio-1]"),
            phoneNumberInput = $("[id=userNumber]"),
            adressInput = $("[id=currentAddress]"),
            dateOfBirthInput = $("[id=dateOfBirthInput]"),
            subjectsInput = $("[id=subjectsInput]"),
            selectSportCheckbox =  $("[id=hobbies-checkbox-1]"),
            selectReadingCheckbox =  $("[id=hobbies-checkbox-2]");

    public RegistrationPage openPage(){
        open("https://demoqa.com/automation-practice-form");
        namePage.shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectGenderMale(){
        genderMaleRadiobutton.doubleClick();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value){
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setAdress(String value){
        adressInput.setValue(value);
        return this;
    }

    public RegistrationPage setBerthDay(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears(){
        registationResultsModal.registrationModalAppears();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value){
        registationResultsModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectsInput.click();
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        subjectsInput.pressTab();
        return this;
    }

    public RegistrationPage selectSports(){
        selectSportCheckbox.parent().click();
        return this;
    }

    public RegistrationPage selectReading(){
        selectReadingCheckbox.parent().click();
        return this;
    }

    public RegistrationPage uploadPicture(String value){
        $("[id=uploadPicture]").uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setState(String value){
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(byText(value)).click();
        return this;
    }

    public RegistrationPage submit(){
        $("[id=submit]").click();
        return this;
    }

    public RegistrationPage registrationResultSubmit(){
        registationResultsModal.submit();
        return this;
    }









}
