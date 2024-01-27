package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage extends TestBase {
    @Step("Open edit profile")
    public ProfilePage openEditProfile() {
        $("[data-test-id=header-menu-options-settings]").click();
        return this;
    }

    @Step("Upload jpeg")
    public ProfilePage uploadJpeg() {
        $("[aria-label='Change profile picture']").click();
        $("#file-input").uploadFile(new File("src/test/resources/test.jpg"));
        return this;
    }

    @Step("Fill about")
    public ProfilePage fillAbout(String about) {
        $("#about").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#about").setValue(about);
        return this;
    }

    @Step("Set pronouns")
    public ProfilePage setPronouns(String pronouns) {
        $("[aria-label='Clear the current value']").click();
        $("#combobox-pronouns").click();
        $("#pronouns").$(byText(pronouns)).click();
        return this;
    }

    @Step("Fill website")
    public ProfilePage fillWebsite(String website) {
        $("#listed_website_url").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#listed_website_url").setValue(website);
        return this;
    }

    @Step("Fill email")
    public ProfilePage fillEmail(String email) {
        $("#partner_contact_email").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#partner_contact_email").setValue(email);
        return this;
    }

    @Step("Set country code")
    public ProfilePage setCountryCode(String code) {
        $("#partner_address_line_1").scrollIntoView(false);
        $("#countryCode").click();
        $(byText(code)).click();
        return this;
    }

    @Step("Fill phone number")
    public ProfilePage fillPhoneNumber(String number) {
        $("#phoneNumber").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#phoneNumber").setValue(number);
        return this;
    }

    @Step("click enable profile address")
    public ProfilePage clickEnableProfileAddress() {
        $("#enable_profile_address").click();
        return this;
    }

    @Step("Click button save")
    public ProfilePage clickButtonSave() {
        $("[data-test-id=done-button]").click();
        return this;
    }

    @Step("Check notification")
    public ProfilePage checkNotification() {
        $("[data-test-id=save-settings-toast]").click();
        return this;
    }

    @Step("Clear fields")
    public ProfilePage clearFields() {
        $("#business_name").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#username").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#about").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("[aria-label='Clear the current value']").click();
        $("#listed_website_url").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#phoneNumber").sendKeys(Keys.chord(Keys.END, Keys.SHIFT, Keys.HOME, Keys.BACK_SPACE));
        $("#enable_profile_address").click();
        return this;
    }

    @Step("Check error business name")
    public ProfilePage checkErrorBusinessName(String error) {
        $("#business_name-error").shouldHave(Condition.text(error));
        return this;
    }

    @Step("Check error business name")
    public void checkErrorUsername(String error) {
        $("#username-error").shouldHave(Condition.text(error));
    }
}
