package guru.qa.tests;

import guru.qa.pages.DiscountsPage;
import guru.qa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DiscountsPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    DiscountsPage discountsPage = new DiscountsPage();

    @Test
    @DisplayName("Проверка работоспособности раздела Бонусы и скидки")
    void checkDiscountsContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
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
