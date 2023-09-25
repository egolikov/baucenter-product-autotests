package guru.qa.tests;

import guru.qa.pages.DiscountsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DiscountsPageTest extends BaseTest {

    DiscountsPage discountsPage = new DiscountsPage();

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Бонусы и скидки")
    void checkDiscountsContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
        });

        step("Нажать кнопку Новинки", () -> {
            mainPage.clickDiscountsButton();
        });

        step("Проверка отображения заголовка Бонусы и скидки после перехода на страницу с Бонусами и скидками", () -> {
            discountsPage.checkDiscountsTitle("Бонусы и скидки — выгодно для всех!");
        });

        step("Проверка содержания контента на странице Бонусы и скидки", () -> {
            discountsPage.checkDiscountsContent();
        });
    }
}
