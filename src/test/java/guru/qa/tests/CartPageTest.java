package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CartPageTest extends BaseTest {

    @Test
    @Tag("Smoke")
    @Tag("Cart")
    @DisplayName("Проверка добавления и отображения товара в Корзине")
    void checkCartContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Ввести в поле Поиска текст и нажать Enter", () -> {
            mainPage.searchInputText("дверь");
        });

        step("Добавить товар в корзину", () -> {
            searchPage.addToCart();
        });

        step("Открыть страницу Товары", () -> {
            cartPage.openPage();
        });

        step("Проверка отображения заголовка Товара после перехода на страницу с Товарами", () -> {
            cartPage.checkCartTitle("Дверь");
        });

        step("Проверка нахождения товара в Корзине", () -> {
            cartPage.checkCartContent();
        });
    }
}
