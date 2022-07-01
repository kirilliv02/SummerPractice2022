package yandex;

import core.BaseSeleniumTest;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

public class Test3 extends BaseSeleniumTest {

    @Test
    public void successGetSearchButtonTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getSearchButtonText();
        collector.checkThat(logoText, is("Найти"));
    }

    @Test
    public void errorGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("яндекс"));
    }

    @Test
    public void errorGetDownloadBrowserLinkTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getDownloadBrowserLinkText();
        collector.checkThat(logoText, is("Установите медленный браузер"));
    }

    @Test
    public void errorGetSearchInputPlaceholderTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getSearchInputPlaceholderText();
        collector.checkThat(logoText, is("Найдется многое"));
    }

    @Test
    public void errorGetCityNameTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getCityNameText();
        collector.checkThat(logoText, is("Москва"));
    }

}
