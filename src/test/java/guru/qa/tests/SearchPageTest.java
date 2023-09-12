package guru.qa.tests;

import guru.qa.pages.MainPage;
import guru.qa.pages.SearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchPageTest extends BaseTest {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
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
