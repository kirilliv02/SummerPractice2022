package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.junit.Assert;
import org.junit.Test;

/**
 * Third test from task
 */

public class Test3 extends BaseSeleniumTest {


    /**
     * Successful check search button text without any errors.
     * Error check yandex logo text.
     * Error check download browser link text.
     * Error check search input placeholder text.
     * Error check city name text.
     */
    @Test(expected = CityNameNotFoundException.class)
    @Description(useJavaDoc = true)
    public void allTests() {
        getSearchButtonTextTest();
        getLogoTextTest();
        getDownloadBrowserLinkTextTest();
        getSearchInputPlaceholderTextTest();
        getCityNameTextTest();
    }

    @Step("Get search button text test")
    public void getSearchButtonTextTest() {
        String searchButtonText = searchPage.getSearchButtonText();


        try {
            Assert.assertEquals("Найти", searchButtonText);
            addScreenshot();
        } catch (Throwable e) {
            String errorMessage = "Текст кнопки поиска не соответствует";
            collector.addError(new SearchButtonNotFoundException(errorMessage));

            addScreenshot();
            addDescription(errorMessage);

            Allure.getLifecycle().updateStep((stepResult)->stepResult.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep();
        }
    }

    @Step("Get logo text test")
    public void getLogoTextTest() {
        String logoText = searchPage.getLogoText();

        try {
            Assert.assertEquals("яндекс", logoText);
            addScreenshot();
        } catch (Throwable e) {
            String errorMessage = "Название логотипа не соответствует";
            collector.addError(new LogoNotFoundException(errorMessage));

            addScreenshot();
            addDescription(errorMessage);

            Allure.getLifecycle().updateStep((stepResult)->stepResult.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep();
        }
    }

    @Step("Get download browser link text test")
    public void getDownloadBrowserLinkTextTest() {
        String downloadBrowserLinkText = searchPage.getDownloadBrowserLinkText();

        try {
            Assert.assertEquals("браузер", downloadBrowserLinkText);
            addScreenshot();
        } catch (Throwable e) {
            String errorMessage = "Текст ссылки на скачивание яндекс браузера не соотвествует";
            collector.addError(new DownloadBrowserLinkNotFoundException(errorMessage));

            addScreenshot();
            addDescription(errorMessage);

            Allure.getLifecycle().updateStep((stepResult)->stepResult.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep();
        }

    }

    @Step("Get search input placeholder text test")
    public void getSearchInputPlaceholderTextTest() {
        String searchInputPlaceholderText = searchPage.getSearchInputPlaceholderText();


        try {
            Assert.assertEquals("Найдется многое", searchInputPlaceholderText);
            addScreenshot();
        } catch (Throwable e) {
            String errorMessage = "Плейсхолдер поля ввода для поиска не соотвествуе";
            collector.addError(new SearchInputPlaceholderNotFoundException(errorMessage));

            addScreenshot();
            addDescription(errorMessage);

            Allure.getLifecycle().updateStep((stepResult)->stepResult.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep();
        }
    }

    @Step("Get city name text test")
    public void getCityNameTextTest() {
        String cityNameText = searchPage.getCityNameText();


        try {
            Assert.assertEquals("Москва", cityNameText);
            addScreenshot();
        } catch (Throwable e) {
            String errorMessage = "Имя города не соответствует";
            collector.addError(new CityNameNotFoundException(errorMessage));

            addScreenshot();
            addDescription(errorMessage);

            Allure.getLifecycle().updateStep((stepResult)->stepResult.setStatus(Status.FAILED));
            Allure.getLifecycle().stopStep();
        }
    }


}
