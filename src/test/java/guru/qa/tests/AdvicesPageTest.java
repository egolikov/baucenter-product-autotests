package guru.qa.tests;

import guru.qa.pages.AdvicesPage;
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
public class AdvicesPageTest extends BaseTest {

    protected AdvicesPage advicesPage = new AdvicesPage();

    @Severity(NORMAL)
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

        step("Проверка наличия материала [«Уютное свечение» проект оформления фасада] на странице Советы", () -> {
            advicesPage.checkElementOnPageContent("«Уютное свечение» проект оформления фасада");
        });

        step("Проверка наличия материала [Как выбрать надежную, красивую и комфортную ванну] на странице Советы", () -> {
            advicesPage.checkElementOnPageContent("Как выбрать надежную, красивую и комфортную ванну");
        });

        step("Проверка наличия материала [Используем свет по-умному] на странице Советы", () -> {
            advicesPage.checkElementOnPageContent("Используем свет по-умному");
        });
    }
}
