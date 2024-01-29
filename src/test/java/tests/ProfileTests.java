package tests;

import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.AuthorizationPage;
import pages.ProfilePage;

@Tag("smoke")

public class ProfileTests extends TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    ProfilePage profilePage = new ProfilePage();


    @Test
    @DisplayName("Edite profile")
    void editeProfile() {
        authorizationPage.authorizationUser(TestData.email, TestData.password, TestData.email);
        profilePage.openEditProfile()
                .uploadJpeg()
                .fillAbout(TestData.random)
                .setPronouns(TestData.pronouns)
                .fillWebsite(TestData.website)
                .fillEmail(TestData.email)
                .setCountryCode(TestData.countryCode)
                .fillPhoneNumber(TestData.number)
                .clickEnableProfileAddress()
                .clickButtonSave()
                .checkNotification();
    }

    @Test
    @DisplayName("Check error messages")
    void checkErrorMessages() {
        authorizationPage.authorizationUser(TestData.email, TestData.password, TestData.email);
        profilePage.openEditProfile()
                .clearFields()
                .checkErrorBusinessName("Your profile needs a name")
                .checkErrorUsername("Your profile needs a username");
    }

    @DisplayName("Search profile")
    @ParameterizedTest
    @CsvSource(value = {"We Love Cats and Kittens, catsandkittys",
                        "Dogs Trust, dogstrust"})
    void searchProfile(String value, String expectText) {
        profilePage.clickExplore()
                .fillSearch(value)
                .checkProfile(expectText);
    }
}
