package yandex;

import core.BaseSeleniumTest;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

/**
 * Second test from task
 */
public class Test2 extends BaseSeleniumTest {

    /**
     * Error check yandex logo text
     */
    @Test
    public void errorGetLogoTextTest() {
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("яндекс"));
    }
}
