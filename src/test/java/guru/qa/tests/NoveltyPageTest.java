package guru.qa.tests;

import guru.qa.pages.MainPage;
import guru.qa.pages.NoveltyPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class NoveltyPageTest extends BaseTest {


    MainPage mainPage = new MainPage();
    NoveltyPage noveltyPage = new NoveltyPage();

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Новинки")
    void checkNoveltyContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Нажать кнопку Новинки", () -> {
            mainPage.clickNoveltyButton();
        });

        step("Проверка отображения заголовка Новинки после перехода на страницу с Новинками", () -> {
            noveltyPage.checkNoveltyTitle("Новинки каталога");
        });

        step("Проверка содержания контента на странице Новинки", () -> {
            noveltyPage.checkNoveltyContent();
        });

    }
}
