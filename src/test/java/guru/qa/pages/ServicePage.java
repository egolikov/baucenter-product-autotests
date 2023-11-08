package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ServicePage {

    private final SelenideElement serviceContent = $(".services-block"),
            title = $(".h1");

    private final ElementsCollection serviceContents = $$(".services-block_item_heading.h3");

    public ServicePage openPage() {
        open("/services");

        return this;
    }

    public ServicePage checkServiceTitle(String value) {
        title.shouldHave(text(value));

        return this;
    }

    public ServicePage checkServiceContent() {
        serviceContent.shouldNotBe(empty);

        return this;
    }

    public ServicePage checkElementOnPageContent(String value) {
        serviceContents.filter(text(value)).first().shouldBe(visible);

        return this;
    }
}
