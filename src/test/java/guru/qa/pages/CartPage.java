package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {

    SelenideElement cartContent = $(".co-item"),
                    title = $(".co-item__name");

    public CartPage openPage() {
        open("/personal/cart");

        return this;
    }

    public CartPage checkCartTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public CartPage checkCartContent() {
        cartContent.shouldNotBe(empty);

        return this;
    }
}
