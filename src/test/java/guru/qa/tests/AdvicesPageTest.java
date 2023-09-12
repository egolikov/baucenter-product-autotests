package guru.qa.tests;

import guru.qa.pages.AdvicesPage;
import guru.qa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AdvicesPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AdvicesPage advicesPage = new AdvicesPage();

    @Test
    @DisplayName("Проверка работоспособности раздела Советы")
    void checkAdvicesContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
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
