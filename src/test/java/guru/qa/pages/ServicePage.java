package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ServicePage {

    SelenideElement serviceContent = $(".services-block"),
                    title = $(".h1");

    public ServicePage checkServiceTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public ServicePage checkServiceContent() {
        serviceContent.shouldNotBe(empty);

        return this;
    }
}
