package guru.qa.tests;

import guru.qa.pages.ActionsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ActionsPageTest extends BaseTest {

    ActionsPage actionsPage = new ActionsPage();

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Акции")
    void checkActionsContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
        });

        step("Нажать кнопку Акции", () -> {
            mainPage.clickActionsButton();
        });

        step("Проверка отображения заголовка Акции после перехода на страницу с Акциями", () -> {
            actionsPage.checkActionsTitle("Действующие акции и специальные предложения");
        });

        step("Проверка содержания контента на странице Акции", () -> {
            actionsPage.checkActionsContent();
        });
    }
}
