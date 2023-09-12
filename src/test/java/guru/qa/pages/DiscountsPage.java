package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DiscountsPage {

    SelenideElement  discountsContent = $(".bonuses-block_wrap"),
                     title = $(".paddings.h2");

    public DiscountsPage checkDiscountsTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public DiscountsPage checkDiscountsContent() {
        discountsContent.shouldNotBe(empty);

        return this;
    }
}
