package guru.qa.tests;

import guru.qa.pages.NoveltyPage;
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
public class NoveltyPageTest extends BaseTest {

    protected NoveltyPage noveltyPage = new NoveltyPage();

    @Severity(NORMAL)
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

        step("Проверка наличия каталога [Турецкие ковры с новыми дизайнами] на странице Новинки", () -> {
            noveltyPage.checkElementOnPageContent("Турецкие ковры с новыми дизайнами");
        });

        step("Проверка наличия каталога [Монтажный газовый пистолет] на странице Новинки", () -> {
            noveltyPage.checkElementOnPageContent("Монтажный газовый пистолет");
        });

        step("Проверка наличия каталога [Глянцевая краска по металлу от Hammerite] на странице Новинки", () -> {
            noveltyPage.checkElementOnPageContent("Глянцевая краска по металлу от Hammerite");
        });
    }
}
