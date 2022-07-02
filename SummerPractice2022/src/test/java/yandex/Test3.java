package yandex;

import core.BaseSeleniumTest;
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
     */
    @Test
    public void errorGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("яндекс"));
    }

    /**
     * Error check download browser link text
     */
    @Test
    public void errorGetDownloadBrowserLinkTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getDownloadBrowserLinkText();
        collector.checkThat(logoText, is("Установите медленный браузер"));
    }

    /**
     * Error check search input placeholder text
     */
    @Test
    public void errorGetSearchInputPlaceholderTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getSearchInputPlaceholderText();
        collector.checkThat(logoText, is("Найдется многое"));
    }

    /**
     * Error check city name text
     */
    @Test
    public void errorGetCityNameTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getCityNameText();
        collector.checkThat(logoText, is("Москва"));
    }

}
