package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class NoveltyPage {

    private final SelenideElement noveltyContent = $(".otherActions"),
            title = $("#h1_title");

    private final ElementsCollection noveltyContents = $$(".otherAdvice");

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

    public NoveltyPage checkElementOnPageContent(String value) {
        noveltyContents.filter(text(value)).first().shouldBe(visible);

        return this;
    }
}
