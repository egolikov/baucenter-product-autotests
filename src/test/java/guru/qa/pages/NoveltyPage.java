package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NoveltyPage {

    SelenideElement noveltyContent = $(".otherActions"),
            title = $("#h1_title");

    public NoveltyPage openPage() {
        open("/new");

        return this;
    }

    public NoveltyPage checkNoveltyTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public NoveltyPage checkNoveltyContent() {
        noveltyContent.shouldNotBe(empty);

        return this;
    }
}
