package guru.qa.tests;

import guru.qa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class CategoriesMainPageTest extends BaseTest {
    MainPage mainPage = new MainPage();
    List<String> expectedCategories = List.of("Сад", "Стройматериалы", "Инструменты", "Крепеж и скобяные изделия",
                                                "Водоснабжение, отопление, вентиляция", "Электротовары", "Краски и строительная химия",
                                                "Освещение", "Обои, интерьер, декор", "Кухни", "Плитка", "Сантехника", "Напольные покрытия",
                                                "Двери, лестницы, окна", "Хранение", "Товары для дома и уборки");

    @Test
    @DisplayName("Проверка наличия всех категорий в Каталоге товаров")
    void checkCategoriesList() {

        step("Открыть Главную Страницу", () -> {
        mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
        });

        step("Нажать кнопку Каталог товаров", () -> {
        mainPage.clickCategoryButton();
        });

        step("Проверка наличия всех категорий", () -> {
        mainPage.checkCategoryList(expectedCategories);
        });

    }
}
