package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DiscountsPage {

    private final SelenideElement discountsContent = $(".bonuses-block_wrap"),
            title = $(".paddings.h2");

    private final ElementsCollection discountsContents = $$(".bonuses-block_item_title");

    public DiscountsPage openPage() {
        open("/discounts");

        return this;
    }

    public DiscountsPage checkDiscountsTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public DiscountsPage checkDiscountsContent() {
        discountsContent.shouldNotBe(empty);

        return this;
    }

    public DiscountsPage checkElementOnPageContent(String value) {
        discountsContents.filter(text(value)).first().shouldBe(visible);

        return this;
    }
}