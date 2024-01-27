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

//    @Test
//    @DisplayName("Unsuccessful authorization with wrong password")
//    void authorizationWithWrongPassword(){
//        authorizationPage.clickButtonLogin()
//                .fillFieldEmail(TestData.email)
//                .fillFieldPassword("1111111")
//                .clickButtonSubmit()
//                .checkAlert("Вы ввели неправильный пароль. Повторите попытку или Сбросить пароль");
//    }
//
//    @Test
//    @DisplayName("Unsuccessful authorization with empty credentials")
//    void authorizationWithEmptyCredentials(){
//        authorizationPage.clickButtonLogin()
//                .fillFieldEmail("")
//                .fillFieldPassword("")
//                .clickButtonSubmit()
//                .checkAlert("Вы кое-что забыли! Укажите свой адрес электронной почты.");
//    }
}
