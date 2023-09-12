package guru.qa.tests;

import guru.qa.pages.MainPage;
import org.junit.jupiter.api.Test;

public class AutoruzationTest {

    MainPage mainPage = new MainPage();

    @Test
    void successfulAutorization() {
        mainPage.openPage();
        mainPage.clickAuthorization();
    }

}
