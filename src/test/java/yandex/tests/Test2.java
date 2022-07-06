package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.LogoNotFoundException;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

/**
 * Second test from task
 */
public class Test2 extends BaseSeleniumTest {

    /**
     * Error check yandex logo text
     * @throws LogoNotFoundException if logo does not match
     */
    @Test(expected = LogoNotFoundException.class)
    public void errorGetLogoTextTest() throws LogoNotFoundException{
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        try {
            Assert.assertEquals("яндекс", logoText);
        } catch (Throwable e) {
            collector.addError(new LogoNotFoundException("Logo does not match"));
        }
    }
}
