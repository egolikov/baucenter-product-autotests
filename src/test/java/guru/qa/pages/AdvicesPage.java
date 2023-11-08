package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AdvicesPage {

    private final SelenideElement advicesContent = $(".ib-wrapper"),
            title = $("#h1_title");

    private final ElementsCollection advicesContents = $$(".advice_item");

    public AdvicesPage openPage() {
        open("/advices");

        return this;
    }

    public AdvicesPage checkAdvicesTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public AdvicesPage checkAdvicesContent() {
        advicesContent.shouldNotBe(empty);

        return this;
    }

    public AdvicesPage checkElementOnPageContent(String value) {
        advicesContents.filter(text(value)).first().shouldBe(visible);

        return this;
    }
}
