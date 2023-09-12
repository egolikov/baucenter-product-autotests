package guru.qa.tests;

import guru.qa.pages.MainPage;
import guru.qa.pages.ServicePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ServicePageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    ServicePage servicePage = new ServicePage();

    @Test
    @DisplayName("Проверка работоспособности раздела Сервис")
    void checkServiceContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать кнопку Сервис", () -> {
            mainPage.clickServiceButton();
        });

        step("Проверка отображения заголовка Сервис после перехода на страницу с Сервисом", () -> {
            servicePage.checkServiceTitle("Сервис для покупателей — легко и просто!");
        });

        step("Проверка содержания контента на странице Сервис", () -> {
            servicePage.checkServiceContent();
        });

    }
}
