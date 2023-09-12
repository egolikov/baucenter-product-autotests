package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ActionsPage {

    SelenideElement actionsContent = $(".action-page-wrapper"),
                    title = $("#h1_title");

    public ActionsPage checkActionsTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public ActionsPage checkActionsContent() {
        actionsContent.shouldNotBe(empty);

        return this;
    }
}
