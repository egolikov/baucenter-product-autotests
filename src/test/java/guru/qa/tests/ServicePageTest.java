package guru.qa.tests;

import guru.qa.pages.ServicePage;
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
public class ServicePageTest extends BaseTest {

    protected ServicePage servicePage = new ServicePage();

    @Severity(NORMAL)
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

        step("Проверка наличия вида сервиса [Возврат товаров] на странице Сервис", () -> {
            servicePage.checkElementOnPageContent("Возврат товара");
        });

        step("Проверка наличия вида сервиса [Обжим кабеля] на странице Сервис", () -> {
            servicePage.checkElementOnPageContent("Обжим кабеля");
        });

        step("Проверка наличия вида сервиса [Дизайн-проект ванной. БЕСПЛАТНО] на странице Сервис", () -> {
            servicePage.checkElementOnPageContent("Дизайн-проект ванной. БЕСПЛАТНО");
        });
    }
}
