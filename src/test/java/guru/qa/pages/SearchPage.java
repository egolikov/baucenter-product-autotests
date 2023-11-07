package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private final SelenideElement searchContent = $(".ib-wrapper"),
            title = $("#h1_title"),
            addToCartButton = $("[data-tooltip-text='Добавить в корзину']"),
            addedToCart = $(".price-block_cart-added");

    public SearchPage openPage() {
        open("/search");

        return this;
    }

    public SearchPage checkSearchTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public SearchPage checkSearchContent() {
        searchContent.shouldNotBe(empty);

        return this;
    }

    public SearchPage clickOnButtonAddToCart() {
        addToCartButton.click();
        addedToCart.shouldBe(visible);

        return this;
    }
}
