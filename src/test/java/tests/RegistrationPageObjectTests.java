package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageObjectTests extends TestBase{

    private String firstName = "Ivan";
    private String lastName = "Ulianov";
    private String email = "some.email@gmail.com";
    private String phone = "1234567890";
    private String address = "some address";



    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGenderMale()
                .setPhoneNumber(phone)
                .setBerthDay("16", "September", "1983")
                .setSubjects("physics")
                .selectSports()
                .selectReading()
                .uploadPicture("src/test/resources/HG.jpg")
                .setAdress(address)
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", "male")
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", "16 September,1983")
                .verifyResults("Subjects", "Physics")
                .verifyResults("Hobbies", "Sports, Reading")
                .verifyResults("Picture", "HG.jpg")
                .verifyResults("Address", address)
                .verifyResults("State and City", "NCR Delhi")
                .registrationResultSubmit();








    }

    @Test
    void fillFormTest1() {

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.selectGenderMale();
        registrationPage.setPhoneNumber(phone);


        //$("[id=gender-radio-1]").doubleClick();
        //$("[id=userNumber]").setValue(phone);



        $("[id=subjectsInput]").click();
        $("[id=subjectsInput]").setValue("physics");
        $("[id=subjectsInput]").pressEnter();
        $("[id=subjectsInput]").pressTab();
        $("[id=hobbies-checkbox-1]").parent().click();
        $("[id=hobbies-checkbox-2]").parent().click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/HG.jpg"));
        registrationPage.setAdress(address);
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(byText("Delhi")).click();
        $("[id=submit]").click();


        registrationPage.verifyResultsModalAppears();
        $("[class=modal-content]").shouldHave(text(firstName));
        $("[class=modal-content]").shouldHave(text(lastName));
        $("[class=modal-content]").shouldHave(text(email));
        $("[class=modal-content]").shouldHave(text("Male"));
        $("[class=modal-content]").shouldHave(text(phone));
        $("[class=modal-content]").shouldHave(text("16 September,1983"));
        $("[class=modal-content]").shouldHave(text("Physics"));
        $("[class=modal-content]").shouldHave(text("Sports, Reading"));
        $("[class=modal-content]").shouldHave(text("HG.jpg"));
        $("[class=modal-content]").shouldHave(text(address));
        $("[class=modal-content]").shouldHave(text("NCR Delhi"));
        $("[id=closeLargeModal]").click();
    }
}
