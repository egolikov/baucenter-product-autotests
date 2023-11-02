package guru.qa.tests;

import guru.qa.pages.AuthorizationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

import guru.qa.config.AuthorizationConfig;
import guru.qa.config.BadAuthorizationConfig;
import guru.qa.config.ConfigManager;

@Owner("Голиков Евгений")
@Epic(value = "Тестирование веб приложения Бауцентр")
@Feature(value = "Новая фунциональность веб приложения Бауцентр")
@Story("Авторизация")
public class AuthorizationTest extends BaseTest {

    private final AuthorizationConfig authorizationConfig = ConfigManager.getAuthorization();
    private final BadAuthorizationConfig badAuthorizationConfig = ConfigManager.getBadAuthorization();

    protected AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Успешная авторизация")
    void successfulAuthorization() {

        step("Открыть страницу Авторизации", () -> {
            authorizationPage.openPage();
        });

        step("Ввести валидный Логин", () -> {
            authorizationPage.setLogin(authorizationConfig.Username());
        });

        step("Ввести валидный Пароль", () -> {
            authorizationPage.setPassword(authorizationConfig.Password());
        });

        step("Нажать кнопку Войти", () -> {
            authorizationPage.clickOnSubmitButton();
        });

        step("Проверка наличия текста с успешной Авторизацией", () -> {
            authorizationPage.checkSuccessfulAuthorization("Здравствуйте, Евгений!");
        });
    }

    @Test
    @Tag("Smoke")
    @Tag("Authorization")
    @DisplayName("Неуспешная авторизация")
    void failedAuthorization() {

        step("Открыть страницу Авторизации", () -> {
            authorizationPage.openPage();
        });

        step("Ввести невалидный Логин", () -> {
            authorizationPage.setLogin(badAuthorizationConfig.BadUserName());
        });

        step("Ввести невалидный Пароль", () -> {
            authorizationPage.setPassword(badAuthorizationConfig.BadPassword());
        });

        step("Нажать кнопку Войти", () -> {
            authorizationPage.clickOnSubmitButton();
        });

        step("Проверка наличия текста с ошибкой Авторизации", () -> {
            authorizationPage.checkErrorAuthorization("Неверная комбинация логина и пароля. Для быстрого восстановления пароля нажмите на ссылку «Забыли пароль?».");
        });
    }
}
