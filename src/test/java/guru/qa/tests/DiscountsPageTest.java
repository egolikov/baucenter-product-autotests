package guru.qa.tests;

import guru.qa.pages.DiscountsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование веб приложения Бауцентр")
@Feature(value = "Новая фунциональность веб приложения Бауцентр")
@Story("Функциональность разделов")
public class DiscountsPageTest extends BaseTest {

    protected DiscountsPage discountsPage = new DiscountsPage();

    @Severity(NORMAL)
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

        step("Проверка наличия бонусной карты [Бонусная карта Бауцентр - Бонус] на странице Бонусы и скидки", () -> {
            discountsPage.checkElementOnPageContent("Бонусная карта \"Бауцентр - Бонус\"");
        });

        step("Проверка наличия скидочной карты [Карта скидок отдела Профи] на странице Бонусы и скидки", () -> {
            discountsPage.checkElementOnPageContent("Карта скидок отдела \"Профи\"");
        });
    }
}
