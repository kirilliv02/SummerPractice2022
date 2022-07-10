package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.CityNameNotFoundException;
import exceptions.DownloadBrowserLinkNotFoundException;
import exceptions.LogoNotFoundException;
import exceptions.SearchInputPlaceholderNotFoundException;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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
     */
    @Test(expected = NoSuchElementException.class)
    @Description(useJavaDoc = true, value = "1 successful and 4 failed tests")
    public void allTests() throws NoSuchElementException {
        SearchPage searchPage = new SearchPage();

        getSearchButtonTextTest(searchPage);
        getLogoTextTest(searchPage);
        getDownloadBrowserLinkTextTest(searchPage);
        getSearchInputPlaceholderTextTest(searchPage);
        getCityNameTextTest(searchPage);
    }

    @Step("Get search button text test")
    public void getSearchButtonTextTest(SearchPage searchPage){
        String searchButtonText = searchPage.getSearchButtonText();

        collector.checkThat(searchButtonText, is("Найти"));

        addScreenshot();
    }

    @Step("Get logo text test")
    public void getLogoTextTest(SearchPage searchPage){
        String logoText = searchPage.getLogoText();

        try {
            Assert.assertEquals("яндекс", logoText);
        } catch (Throwable e) {
            collector.addError(new LogoNotFoundException("Название логотипа не соответствует"));
        }

        addScreenshot();
        addDescription("Название логотипа не соответствует");
    }

    @Step("Get download browser link text test")
    public void getDownloadBrowserLinkTextTest(SearchPage searchPage){
        String downloadBrowserLinkText = searchPage.getDownloadBrowserLinkText();

        try {
            Assert.assertEquals("Установите медленный браузер", downloadBrowserLinkText);
        } catch (Throwable e) {
            collector.addError(new DownloadBrowserLinkNotFoundException("Текст ссылки на скачивание яндекс браузера не соотвествует"));
        }

        addScreenshot();
        addDescription("Текст ссылки на скачивание яндекс браузера не соотвествует");

    }

    @Step("Get search input placeholder text test")
    public void getSearchInputPlaceholderTextTest(SearchPage searchPage){
        String searchInputPlaceholderText = searchPage.getSearchInputPlaceholderText();

        try {
            Assert.assertEquals("Найдется многое", searchInputPlaceholderText);
        } catch (Throwable e) {
            collector.addError(new SearchInputPlaceholderNotFoundException("Плейсхолдер поля ввода для поиска не соотвествует"));
        }

        addScreenshot();
        addDescription("Плейсхолдер поля ввода для поиска не соотвествует");

    }

    @Step("Get city name text test")
    public void getCityNameTextTest(SearchPage searchPage){
        String cityNameText = searchPage.getCityNameText();

        try {
            Assert.assertEquals("Москва", cityNameText);
        } catch (Throwable e) {
            collector.addError(new CityNameNotFoundException("Имя города не соответствует"));
        }

        addScreenshot();
        addDescription("Имя города не соответствует");
    }



}
