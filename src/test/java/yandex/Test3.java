package yandex;

import core.BaseSeleniumTest;
import exceptions.CityNameNotFoundException;
import exceptions.DownloadBrowserLinkNotFoundException;
import exceptions.LogoNotFoundException;
import exceptions.SearchInputPlaceholderNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

/**
 * Third test from task
 */
public class Test3 extends BaseSeleniumTest {

    /**
     * Successful check search button text without any errors
     */
    @Test
    public void successGetSearchButtonTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getSearchButtonText();
        collector.checkThat(logoText, is("Найти"));
    }

    /**
     * Error check yandex logo text
     * @throws LogoNotFoundException if logo does not match
     */
    @Test
    public void errorGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        try {
            Assert.assertEquals("яндекс", logoText);
        } catch (Throwable e) {
            collector.addError(new LogoNotFoundException("Logo does not match"));
        }
    }

    /**
     * Error check download browser link text
     * @throws DownloadBrowserLinkNotFoundException if download browser link does not match
     */
    @Test
    public void errorGetDownloadBrowserLinkTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getDownloadBrowserLinkText();
        try {
            Assert.assertEquals("Установите медленный браузер", logoText);
        } catch (Throwable e) {
            collector.addError(new DownloadBrowserLinkNotFoundException("Download browser link does not match"));
        }
    }

    /**
     * Error check search input placeholder text
     * @throws SearchInputPlaceholderNotFoundException if search input placeholder does not match
     */
    @Test
    public void errorGetSearchInputPlaceholderTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getSearchInputPlaceholderText();
        try {
            Assert.assertEquals("Найдется многое", logoText);
        } catch (Throwable e) {
            collector.addError(new SearchInputPlaceholderNotFoundException("Search input placeholder does not match"));
        }
    }

    /**
     * Error check city name text
     * @throws CityNameNotFoundException if city name does not match
     */
    @Test
    public void errorGetCityNameTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getCityNameText();
        try {
            Assert.assertEquals("Москва", logoText);
        } catch (Throwable e) {
            collector.addError(new CityNameNotFoundException("City name does not match"));
        }
    }

}
