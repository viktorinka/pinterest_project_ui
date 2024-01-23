package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PinPage {
    @Step("Open page create pin")
    public PinPage openPageCreatePin() {
        open("https://ru.pinterest.com/pin-creation-tool/");
        return this;
    }

    @Step("Upload jpeg")
    public PinPage uploadJpeg() {
        $("[data-test-id=storyboard-upload-input]").uploadFile(new File("src/test/resources/test.jpeg"));
        return this;
    }

    @Step("Fill title")
        public PinPage fillTitle(String title){
        $("#storyboard-selector-title").setValue(title);
        return this;
    }

    @Step("Fill description")
    public PinPage fillDescription(String description){
        $("[data-test-id=comment-editor-container]").setValue(description);
        return this;
    }

    @Step("Fill link")
    public PinPage fillLink(String link){
        $("#WebsiteField").setValue(link);
        return this;
    }

    @Step("Select board")
    public PinPage selectBoard(){
        $("[data-test-id=board-dropdown-select-button]").click();
        $("[data-test-id=boardWithoutSection]").$(byText("Test")).click();
        return this;
    }

    @Step("Select tag")
    public PinPage selectTag(String tag){
        $("#storyboard-selector-interest-tags").setValue(tag);
        $("[data-test-id=storyboard-suggestions-list]").$(byText(tag)).click();
        return this;
    }

    @Step("Click publish button")
    public PinPage clickPublishButton(){
        $("[data-test-id=storyboard-creation-nav-done]").click();
        return this;
    }

    @Step("Check notification")
    public PinPage checkNotification(String notification){
        $("[data-test-id=toast]").shouldHave(Condition.text(notification)).click();
        return this;
    }
}
