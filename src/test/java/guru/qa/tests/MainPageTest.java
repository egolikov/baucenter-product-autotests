package guru.qa.tests;

import guru.qa.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class MainPageTest extends BaseTest {
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

    @Test
    @DisplayName("Проверка работоспособности раздела Акции")
    void checkActionsContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать кнопку Акции", () -> {
            mainPage.clickActionsButton();
        });

        step("Проверка отображения заголовка Акции после перехода на страницу с Акциями", () -> {
            mainPage.checkActionsTitle("Действующие акции и специальные предложения");
        });

        step("Проверка содержания контента на странице Акции", () -> {
            mainPage.checkActionsContent();
        });

    }

    @Test
    @DisplayName("Проверка работоспособности раздела Новинки")
    void checkNoveltyContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать кнопку Новинки", () -> {
            mainPage.clickNoveltyButton();
        });

        step("Проверка отображения заголовка Новинки после перехода на страницу с Новинками", () -> {
            mainPage.checkNoveltyTitle("Новинки каталога");
        });

        step("Проверка содержания контента на странице Новинки", () -> {
                mainPage.checkNoveltyContent();
        });

    }

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
            mainPage.checkDiscountsTitle("Бонусы и скидки — выгодно для всех!");
        });

        step("Проверка содержания контента на странице Бонусы и скидки", () -> {
            mainPage.checkDiscountsContent();
        });

    }

    @Test
    @DisplayName("Проверка работоспособности раздела Сервис")
    void checkServiceContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать кнопку Сервис", () -> {
            mainPage.clickServiceButton();
        });

        step("Проверка отображения заголовка Сервис после перехода на страницу с Сервисом", () -> {
            mainPage.checkServiceTitle("Сервис для покупателей — легко и просто!");
        });

        step("Проверка содержания контента на странице Сервис", () -> {
            mainPage.checkServiceContent();
        });

    }

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
            mainPage.checkAdvicesTitle("Советы и полезные материалы");
        });

        step("Проверка содержания контента на странице Советы", () -> {
            mainPage.checkAdvicesContent();
        });

    }
}
