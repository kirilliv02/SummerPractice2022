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
            collector.addError(new LogoNotFoundException("Название логотипа не соответствует"));
        }

        try {
            Assert.assertEquals("Установите медленный браузер", downloadBrowserLinkText);
        } catch (Throwable e) {
            collector.addError(new DownloadBrowserLinkNotFoundException("Текст ссылки на скачивание яндекс браузера не соотвествует"));
        }

        try {
            Assert.assertEquals("Найдется многое", searchInputPlaceholderText);
        } catch (Throwable e) {
            collector.addError(new SearchInputPlaceholderNotFoundException("Плейсхолдер поля ввода для поиска не соотвествует"));
        }

        try {
            Assert.assertEquals("Москва", cityNameText);
        } catch (Throwable e) {
            collector.addError(new CityNameNotFoundException("Имя города не соответствует"));
        }

    }
}
