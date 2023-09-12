package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.tests.BaseTest;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NoveltyPage extends BaseTest {

    SelenideElement noveltyContent = $(".otherActions"),
                    title = $("#h1_title");

    public NoveltyPage checkNoveltyTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public NoveltyPage checkNoveltyContent() {
        noveltyContent.shouldNotBe(empty);

        return this;
    }
}
