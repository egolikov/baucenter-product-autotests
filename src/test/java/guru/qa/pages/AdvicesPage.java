package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AdvicesPage {

    SelenideElement advicesContent = $(".ib-wrapper"),
                    title = $("#h1_title");


    public AdvicesPage checkAdvicesTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public AdvicesPage checkAdvicesContent() {
        advicesContent.shouldNotBe(empty);

        return this;
    }
}
