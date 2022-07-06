package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.CityNameNotFoundException;
import exceptions.DownloadBrowserLinkNotFoundException;
import exceptions.LogoNotFoundException;
import exceptions.SearchInputPlaceholderNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import yandex.pages.SearchPage;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;

/**
 * Third test from task
 */
public class Test3 extends BaseSeleniumTest {

    /**
     * Successful check search button text without any errors
     * Error check yandex logo text
     * Error check download browser link text
     * Error check search input placeholder text
     * Error check city name text
     *
     * @throws NoSuchElementException if page not contains any text
     */
    @Test(expected = NoSuchElementException.class)
    public void allTests() throws NoSuchElementException {
        SearchPage searchPage = new SearchPage();

        String searchButtonText = searchPage.getSearchButtonText();
        String logoText = searchPage.getLogoText();
        String downloadBrowserLinkText = searchPage.getDownloadBrowserLinkText();
        String searchInputPlaceholderText = searchPage.getSearchInputPlaceholderText();
        String cityNameText = searchPage.getCityNameText();


        collector.checkThat(searchButtonText, is("Найти"));


        try {
            Assert.assertEquals("яндекс", logoText);
        } catch (Throwable e) {
            collector.addError(new LogoNotFoundException("Logo does not match"));
        }

        try {
            Assert.assertEquals("Установите медленный браузер", downloadBrowserLinkText);
        } catch (Throwable e) {
            collector.addError(new DownloadBrowserLinkNotFoundException("Download browser link does not match"));
        }

        try {
            Assert.assertEquals("Найдется многое", searchInputPlaceholderText);
        } catch (Throwable e) {
            collector.addError(new SearchInputPlaceholderNotFoundException("Search input placeholder does not match"));
        }

        try {
            Assert.assertEquals("Москва", cityNameText);
        } catch (Throwable e) {
            collector.addError(new CityNameNotFoundException("City name does not match"));
        }

    }
}
