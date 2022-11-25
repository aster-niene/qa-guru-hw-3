package tests;

import org.junit.jupiter.api.Test;
import testdata.RandomData.*;

import static testdata.RandomData.*;

public class RegistrationPageObjectTests extends TestBase {

    private String
            file = "src/test/resources/HG.jpg";


    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGenderMale()
                .setPhoneNumber(phone)
                .setBerthDay(birthDay, birthMonth, birthYear)
                .setSubjects(subject)
                .selectSports()
                .selectReading()
                .uploadPicture(file)
                .setAdress(address)
                .setState(state)
                .setCity(city)
                .submit();
        registrationPage
                .verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", "male")
                .verifyResults("Mobile", phone)
                .verifyResults("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", "Sports, Reading")
                .verifyResults("Picture", "HG.jpg")
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city)
                .registrationResultSubmit();
    }
}
