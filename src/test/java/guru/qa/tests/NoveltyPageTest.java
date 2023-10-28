package guru.qa.tests;

import guru.qa.pages.NoveltyPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование веб приложения Бауцентр")
@Feature(value = "Новая фунциональность веб приложения Бауцентр")
@Story("Функциональность разделов")
public class NoveltyPageTest extends BaseTest {

    NoveltyPage noveltyPage = new NoveltyPage();

    @Test
    @Tag("Smoke")
    @Tag("NavigationPanel")
    @DisplayName("Проверка работоспособности раздела Новинки")
    void checkNoveltyContent() {

        step("Открыть Главную Страницу", () -> {
            mainPage.openPage();
        });

        step("Убрать всплывающее окно с выбором Города, если появилось на странице", () -> {
            mainPage.removeCityTooltipIfExists();
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
