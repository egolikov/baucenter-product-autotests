package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DiscountsPage {

    private final SelenideElement discountsContent = $(".bonuses-block_wrap"),
            title = $(".paddings.h2");

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
}
