package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    SelenideElement searchContent = $(".ib-wrapper"),
                    title = $("#h1_title");

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
}
