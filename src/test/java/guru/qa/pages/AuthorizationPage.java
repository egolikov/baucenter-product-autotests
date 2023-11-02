package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private final SelenideElement userLogin = $("#USER_LOGIN"),
            userPassword = $("#USER_PASSWORD"),
            submitButton = $("[value='Войти']"),
            successfulMessage = $("#h1_title"),
            errorMessage = $(".s-form_error");

    public AuthorizationPage openPage() {
        open("/personal");

        return this;

    }

    public AuthorizationPage setLogin(String value) {
        userLogin.setValue(value);

        return this;
    }

    public AuthorizationPage setPassword(String value) {
        userPassword.setValue(value);

        return this;
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public AuthorizationPage checkSuccessfulAuthorization(String value) {
        successfulMessage.shouldHave(text(value));

        return this;
    }

    public AuthorizationPage checkErrorAuthorization(String value) {
        errorMessage.shouldHave(text(value));

        return this;
    }
}
