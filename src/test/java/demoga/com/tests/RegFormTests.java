package demoga.com.tests;

import demoga.com.data.Generator;
import demoga.com.pages.RegistrationFormPage;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("demoqa")
public class RegFormTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Generator gen = new Generator();

    //generated or given parameters
    LocalDate birthDate = gen.getDate();
    String firstName = gen.getFirstName();
    String lastName = gen.getLastName();
    String email = gen.getEmail();
    String gender = gen.getGender();
    String phoneNumber = gen.getPhoneNumber();
    String subject = gen.getSubject();
    String hobby = gen.getHobby();
    String imgPath = "IMG_20170318_140030.jpg";
    String address = gen.getAddress();
    String state = gen.getState();
    String city = gen.getCity(state);

    //expected results
    String expectedFullName = format("%s %s", firstName, lastName);
    String expectedMonth = StringUtils.capitalize(birthDate.getMonth().toString().toLowerCase()); //Capitalized month name
    String expectedDate = format("%s %s,%s", birthDate.getDayOfMonth(), expectedMonth, birthDate.getYear());
    String expectedLocation = format("%s %s", state, city);
    String expectedFileName = imgPath.substring(4);


    @Test
    @DisplayName("Successful fill registration test")
    void execute() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(birthDate)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(imgPath)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submitForm()
                .checkTitle("Thanks for submitting the form")
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", expectedDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", expectedFileName)
                .checkResult("Address", address)
                .checkResult("State and City", expectedLocation);
    }

    @Test
    void test1() {
        registrationFormPage.openPage();
        assertTrue(true);
    }

    @Test
    void test2() {
        assertTrue(true);

    }

    @Test
    void test3() {
        assertTrue(true);

    }

}