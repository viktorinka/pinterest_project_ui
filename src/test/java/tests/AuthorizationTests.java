package tests;

import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;

@Tag("simple")
public class AuthorizationTests extends TestBase{
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @DisplayName("Successful authorization")
    void authorizationSuccessful(){
        authorizationPage.clickButtonLogin()
                .fillFieldEmail(TestData.email)
                .fillFieldPassword(TestData.password)
                .clickButtonSubmit()
                .checkAccount(TestData.email);
    }

    @Test
    @DisplayName("Unsuccessful authorization with wrong password")
    void authorizationWithWrongPassword(){
        authorizationPage.clickButtonLogin()
                .fillFieldEmail(TestData.email)
                .fillFieldPassword("1111111")
                .clickButtonSubmit()
                .checkAlert("The password you entered is incorrect. Try again or Reset your password");
    }

    @Test
    @DisplayName("Unsuccessful authorization with empty credentials")
    void authorizationWithEmptyCredentials(){
        authorizationPage.clickButtonLogin()
                .fillFieldEmail("")
                .fillFieldPassword("")
                .clickButtonSubmit()
                .checkAlert("You missed a spot! Don't forget to add your email.");
    }
}
