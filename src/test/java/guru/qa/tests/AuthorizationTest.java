package guru.qa.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

import guru.qa.config.AuthorizationConfig;
import guru.qa.config.BadAuthorizationConfig;
import guru.qa.config.ConfigManager;

public class AuthorizationTest extends BaseTest {

    private final AuthorizationConfig authorizationConfig = ConfigManager.getAuthorization();
    private final BadAuthorizationConfig badAuthorizationConfig = ConfigManager.getBadAuthorization();

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
