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
                    actionsContent = $(".action-page-wrapper"),
                    noveltyButton = $("a[href=\"/new/\"]"),
                    noveltyContent = $(".otherActions"),
                    title = $("#h1_title"),

                    discountsButton = $("a[href=\"/discounts/\"]"),
                    discountsContent = $(".bonuses-block_wrap"),
                    titleD = $(".paddings.h2"),

                    serviceButton = $("a[href=\"/services/\"]"),
                    serviceContent = $(".services-block"),
                    titleS = $(".h1"),

                    advicesButton = $("a[href=\"/advices/\"]"),
                    advicesContent = $(".ib-wrapper"),
                    titleSov = $("#h1_title");

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

    public MainPage checkActionsTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public MainPage checkActionsContent() {
        actionsContent.shouldNotBe(empty);

        return this;
    }

    public MainPage clickNoveltyButton() {
        noveltyButton.click();

        return this;
    }

    public MainPage checkNoveltyTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public MainPage checkNoveltyContent() {
        noveltyContent.shouldNotBe(empty);

        return this;
    }

    public MainPage clickDiscountsButton() {
        discountsButton.click();

        return this;
    }

    public MainPage checkDiscountsTitle(String value) {
        titleD.shouldHave(text(value));

        return this;
    }

    public MainPage checkDiscountsContent() {
        discountsContent.shouldNotBe(empty);

        return this;
    }

    public MainPage clickServiceButton() {
        serviceButton.click();

        return this;
    }

    public MainPage checkServiceTitle(String value) {
        titleS.shouldHave(text(value));

        return this;
    }

    public MainPage checkServiceContent() {
        serviceContent.shouldNotBe(empty);

        return this;
    }

    public MainPage clickAdvicesButton() {
        advicesButton.click();

        return this;
    }

    public MainPage checkAdvicesTitle(String value) {
        titleSov.shouldHave(text(value));

        return this;
    }

    public MainPage checkAdvicesContent() {
        advicesContent.shouldNotBe(empty);

        return this;
    }
}