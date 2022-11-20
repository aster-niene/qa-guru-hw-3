package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistationResultsModal {

    private SelenideElement submitButton =  $("[id=closeLargeModal]");

    public void registrationModalAppears() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

    }

    public void submit(){
        submitButton.click();
    }
}
