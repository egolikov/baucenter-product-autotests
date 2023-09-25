package guru.qa.tests;

import guru.qa.pages.AdvicesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AdvicesPageTest extends BaseTest {

    AdvicesPage advicesPage = new AdvicesPage();

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Советы")
    void checkAdvicesContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
        });

        step("Нажать кнопку Советы", () -> {
            mainPage.clickAdvicesButton();
        });

        step("Проверка отображения заголовка Советы после перехода на страницу с Советами", () -> {
            advicesPage.checkAdvicesTitle("Советы и полезные материалы");
        });

        step("Проверка содержания контента на странице Советы", () -> {
            advicesPage.checkAdvicesContent();
        });
    }
}
