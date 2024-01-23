package tests;

import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.PinPage;

public class CreatePinTests {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    PinPage pinPage = new PinPage();

    @Test
    @DisplayName("Create pin")
    void createPin(){
        authorizationPage.authorizationUser(TestData.email, TestData.password);
        pinPage.openPageCreatePin()
                .uploadJpeg()
                .fillTitle(TestData.random)
                .fillDescription(TestData.random)
                .fillLink(TestData.website)
                .selectBoard()
                .selectTag("cat")
                .clickPublishButton()
                .checkNotification("Your Pin has been published!");
    }
}
