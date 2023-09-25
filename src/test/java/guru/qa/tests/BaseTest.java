package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.WebConfig;
import guru.qa.config.WebConfigProject;
import guru.qa.config.ConfigManager;
import guru.qa.helpers.Attach;
import guru.qa.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    MainPage mainPage = new MainPage();
    private static final WebConfig config = ConfigManager.Instance.read();

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebConfigProject webConfigForProject = new WebConfigProject(config);
        webConfigForProject.webConfig();

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
