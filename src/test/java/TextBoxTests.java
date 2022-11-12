import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    private String firstName = "Ivan";
    private String lastName = "Ulianov";
    private String email = "some.email@gmail.com";
    private String phone = "1234567890";
    private String address = "some address";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=gender-radio-1]").doubleClick();
        $("[id=userNumber]").setValue(phone);
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").click();
        $("[class=react-datepicker__month-select]").selectOption("September");
        $("[class=react-datepicker__year-select]").click();
        $("[class=react-datepicker__year-select]").selectOption("1983");
        $("[class=react-datepicker__year-select]").click();
        $(".react-datepicker__day--016").click(); //todo "I don't know why but it only works like this"
        $("[id=subjectsInput]").click();
        $("[id=subjectsInput]").setValue("physics");
        $("[id=subjectsInput]").pressEnter();
        $("[id=subjectsInput]").pressTab();
        $("[id=hobbies-checkbox-1]").parent().click();
        $("[id=hobbies-checkbox-2]").parent().click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/HG.jpg"));
        $("[id=currentAddress]").setValue(address);
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(byText("Delhi")).click();
        $("[id=submit]").click();


        $("[class=modal-content]").shouldBe(Condition.visible);
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
