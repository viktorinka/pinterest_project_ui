package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage extends TestBase {
    @Step("Open authorization page")
    public AuthorizationPage clickButtonLogin() {
        open("https://ru.pinterest.com/");
        $("[data-test-id=simple-login-button]").click();
        return this;
    }

    @Step("Set field email")
    public AuthorizationPage fillEmail(String email) {
        $("#email").setValue(email);
        return this;
    }

    @Step("Set field password")
    public AuthorizationPage fillPassword(String password) {
        $("#password").setValue(password);
        return this;
    }

    @Step("Click button submit")
    public AuthorizationPage clickButtonSubmit() {
        $("[data-test-id=registerFormSubmitButton]").click();
        return this;
    }

    @Step("Check account email")
    public AuthorizationPage checkAccount(String emailAccount) {
        $("[data-test-id=header-accounts-options-button]").click();
        $("[data-test-id=HeaderAccountsOptionsMenuAccountRep]").shouldHave(Condition.text(emailAccount));
        return this;
    }

    @Step("Check alert")
    public AuthorizationPage checkAlert(String alert) {
        $("[role=alert]").shouldHave(Condition.text(alert));
        return this;
    }

    @Step("Authorization user")
    public void authorizationUser(String email, String password, String emailAccount) {
        clickButtonLogin();
        fillEmail(email);
        fillPassword(password);
        clickButtonSubmit();
        checkAccount(emailAccount);
    }
}
