package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import helpers.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PinPage {
    @Step("Open page create pin")
    public PinPage openPageCreatePin() {
        open("https://ru.pinterest.com/pin-creation-tool/");
        return this;
    }

    @Step("Upload jpeg")
    public PinPage uploadJpeg() {
        $("[data-test-id=storyboard-upload-input]").uploadFile(new File("src/test/resources/test.jpg"));
        return this;
    }

    @Step("Fill title")
    public PinPage fillTitle(String title) {
        $("#storyboard-selector-title").setValue(title);
        return this;
    }

    @Step("Fill description")
    public PinPage fillDescription(String description) {
        $(".public-DraftStyleDefault-block").sendKeys(description);
        return this;
    }

    @Step("Fill link")
    public PinPage fillLink(String link) {
        $("#WebsiteField").setValue(link);
        return this;
    }

    @Step("Select board")
    public PinPage selectBoard() {
        $("[data-test-id=board-dropdown-select-button]").click();
        $("[data-test-id=boardWithoutSection]").$(byText("Test")).click();
        return this;
    }

    @Step("Select tag")
    public PinPage selectTag(String tag) {
        $("#storyboard-selector-interest-tags").setValue(tag);
        $("[data-test-id=storyboard-suggestions-list]").$(byText(tag)).click();
        return this;
    }

    @Step("Click publish button")
    public PinPage clickPublishButton() {
        $("[data-test-id=storyboard-creation-nav-done]").click();
        return this;
    }

    @Step("Check notification")
    public PinPage checkNotification(String notification) {
        $("[data-test-id=toast]").shouldBe(Condition.visible, Duration.ofSeconds(4)).shouldHave(Condition.text(notification));
        return this;
    }

    @Step("Click favorite")
    public PinPage clickFavorite() {
        $("[data-test-id=closeup-favorite-button]").click();
        return this;
    }

    @Step("Click react button")
    public PinPage clickReactButton() {
        $("[data-test-id=react-button]").click();
        return this;
    }

    @Step("Check react button")
    public PinPage checkReactButton() {
        $("[data-test-id=aggregated-reactions-container]").shouldHave(Condition.text("1"));
        return this;
    }

    @Step("Fill comment")
    public PinPage fillComment(String comment) {
        $(".public-DraftStyleDefault-block").sendKeys(comment);
        return this;
    }

    @Step("Click emoji")
    public PinPage clickEmoji() {
        $("[data-test-id=emoji-selector]").click();
        $("[data-full-name='smiling face with 3 hearts,smiling face with smiling eyes and three hearts']").click();
        return this;
    }

    @Step("Send comment")
    public PinPage sendComment() {
        $("[data-test-id=activity-item-create-submit]").click();
        return this;
    }

    @Step("Check comment")
    public PinPage checkComment() {
        $$("[data-test-id=commentThread-comment]").shouldBe(CollectionCondition.size(1));
        return this;
    }

    @Step("Open pin")
    public PinPage openPin() {
        open("dzherommo/test/");
        $("[data-test-id=pinWrapper]").click();
        return this;
    }

    @Step("Delete pin")
    public PinPage deletePin() {
        open("dzherommo/test/");
        $("[data-test-id=pinWrapper]").click();
        $("[data-test-id=closeup-more-options-button]").click();
        $("[data-test-id=pin-action-dropdown-edit-pin]").click();
        $("[data-test-id=delete-pin-button]").click();
        $("[data-test-id=confirm-delete-pin]").click();
        return this;
    }

    @Step("Check delete pin")
    public PinPage checkDeletePin(String notification) {
        $("[data-test-id=toast]").shouldHave(Condition.text(notification));
        return this;
    }
}

