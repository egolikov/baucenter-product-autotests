package guru.qa.tests;

import guru.qa.pages.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование веб приложения Бауцентр")
@Feature(value = "Новая фунциональность веб приложения Бауцентр")
@Story("Поиск")
public class SearchPageTest extends BaseTest {

    protected SearchPage searchPage = new SearchPage();

    @Severity(CRITICAL)
    @Test
    @Tag("Smoke")
    @Tag("Search")
    @DisplayName("Проверка работоспособности Поиска")
    void checkSearchContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Ввести в поле Поиска текст и нажать Enter", () -> {
            mainPage.searchInputText("дверь");
        });

        step("Проверка отображения заголовка Поиск после перехода на страницу с Поиском", () -> {
            searchPage.checkSearchTitle("Результаты поиска по запросу «дверь»");
        });

        step("Проверка содержания контента поиска", () -> {
            searchPage.checkSearchContent();
        });
    }
}
