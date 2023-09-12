package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    SelenideElement categoryButton = $(".top-nav_catalog_heading"),
                    cityTooltip = $(".city-tooltip"),
                    actionsButton = $("a[href=\"/actions/\"]"),
                    noveltyButton = $("a[href=\"/new/\"]"),
                    discountsButton = $("a[href=\"/discounts/\"]"),
                    serviceButton = $("a[href=\"/services/\"]"),
                    advicesButton = $("a[href=\"/advices/\"]");

    ElementsCollection categoryList = $$("#menu-catalog");

    public MainPage openPage() {
        open("/");

        return this;
    }

    public MainPage removeCityTooltipIfExists() {
        if (cityTooltip.exists()) {
            executeJavaScript("document.querySelector('.city-tooltip').remove()");
        }

        return this;
    }

    public MainPage clickCategoryButton() {
        categoryButton.click();

        return this;
    }

    public MainPage checkCategoryList(List<String> expectedCategories) {
        for (String expectedText : expectedCategories) {
            categoryList.findBy(text(expectedText)).shouldBe(visible);
        }
        return this;
    }

    public MainPage clickActionsButton() {
        actionsButton.click();

        return this;
    }

    public MainPage clickNoveltyButton() {
        noveltyButton.click();

        return this;
    }

    public MainPage clickDiscountsButton() {
        discountsButton.click();

        return this;
    }

    public MainPage clickServiceButton() {
        serviceButton.click();

        return this;
    }

    public MainPage clickAdvicesButton() {
        advicesButton.click();

        return this;
    }
}