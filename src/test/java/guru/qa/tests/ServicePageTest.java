package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ServicePageTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Сервис")
    void checkServiceContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
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
