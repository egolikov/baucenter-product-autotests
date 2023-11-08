package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ActionsPage {

    private final SelenideElement actionsContent = $(".action-page-wrapper"),
            title = $("#h1_title");

    private final ElementsCollection actionsContents = $$(".actionBoxBody");

    public ActionsPage openPage() {
        open("/actions");

        return this;
    }

    public ActionsPage checkActionsTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public ActionsPage checkActionsContent() {
        actionsContent.shouldNotBe(empty);

        return this;
    }

    public ActionsPage checkElementOnPageContent(String value) {
        actionsContents.filter(text(value)).first().shouldBe(visible);

        return this;
    }
}
