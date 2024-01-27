package tests;

import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.PinPage;

@Tag("smoke")
public class PinTests extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    PinPage pinPage = new PinPage();

    @Test
    @DisplayName("Create pin")
    void createPin() {
        authorizationPage.authorizationUser(TestData.email, TestData.password, TestData.email);
        pinPage.openPageCreatePin()
                .uploadJpeg()
                .fillTitle(TestData.name)
                .fillDescription(TestData.random)
                .fillLink(TestData.website)
                .selectBoard()
                .selectTag("cat")
                .clickPublishButton()
                .checkNotification("Your Pin has been published!");
    }

    @Test
    @DisplayName("Create pin with social actions")
    void createPinWithSocialActions() {
        authorizationPage.authorizationUser(TestData.email, TestData.password, TestData.email);
        pinPage.openPin()
                .clickFavorite()
                .clickReactButton()
                .clickEmoji()
                .fillComment(TestData.random)
                .sendComment()
                .checkComment()
                .checkReactButton();
    }

    @Test
    @DisplayName("Delete pin")
    void deletePin() {
        authorizationPage.authorizationUser(TestData.email, TestData.password, TestData.email);
        pinPage.deletePin()
                .checkDeletePin("Pin deleted");
    }
}
