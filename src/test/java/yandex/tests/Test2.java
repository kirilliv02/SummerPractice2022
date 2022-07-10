package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.LogoNotFoundException;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import yandex.pages.SearchPage;

/**
 * Second test from task
 */
public class Test2 extends BaseSeleniumTest {

    /**
     * Error check yandex logo text
     */
    @Description(useJavaDoc = true, value = "Error check yandex logo text")
    @Step("Get logo text")
    @Test(expected = LogoNotFoundException.class)
    public void errorGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        try {
            Assert.assertEquals("яндекс", logoText);
        } catch (Throwable e) {
            collector.addError(new LogoNotFoundException("Название логотипа не соответствует"));
        }

        addScreenshot();
        addDescription("Название логотипа не соответствует");
    }
}
