package guru.qa.tests;

import guru.qa.pages.AuthorizationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AuthorizationTest extends BaseTest {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @DisplayName("Успешная авторизация")
    void successfulAuthorization() {

        step("Открыть страницу Авторизации", () -> {
        authorizationPage.openPage();
        });

        step("Ввести валидный Логин", () -> {
        authorizationPage.setLogin("79136696616");
        });

        step("Ввести валидный Пароль", () -> {
        authorizationPage.setPassword("i1f70y7g");
        });

        step("Нажать кнопку Войти", () -> {
        authorizationPage.clickOnSubmitButton();
        });

        step("Проверка наличия текста с успешной Авторизацией", () -> {
        authorizationPage.checkSuccessfulAuthorization("Здравствуйте, Евгений!");
        });

    }

    @Test
    @DisplayName("Неуспешная авторизация")
    void failedAuthorization() {

        step("Открыть страницу Авторизации", () -> {
            authorizationPage.openPage();
        });

        step("Ввести невалидный Логин", () -> {
            authorizationPage.setLogin("7913");
        });

        step("Ввести невалидный Пароль", () -> {
            authorizationPage.setPassword("123qwe");
        });

        step("Нажать кнопку Войти", () -> {
            authorizationPage.clickOnSubmitButton();
        });

        step("Проверка наличия текста с ошибкой Авторизации", () -> {
        authorizationPage.checkErrorAuthorization("Неверная комбинация логина и пароля. Для быстрого восстановления пароля нажмите на ссылку «Забыли пароль?».");
        });

    }
}
