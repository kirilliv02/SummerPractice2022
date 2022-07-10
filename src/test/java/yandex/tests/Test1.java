package yandex.tests;

import core.BaseSeleniumTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

/**
 * First test from task
 */
public class Test1 extends BaseSeleniumTest {

    /**
     * Successful check yandex logo text without any errors
     */
    @Test
    @Description(useJavaDoc = true, value = "Successful check yandex logo text without any errors")
    @Step("Get logo text")
    public void successGetLogoTextTest() {
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("Яндекс"));

        addScreenshot();
    }


}
