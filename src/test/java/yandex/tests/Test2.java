package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.LogoNotFoundException;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.junit.Assert;
import org.junit.Test;


public class Test2 extends BaseSeleniumTest {

    /**
     * Error check yandex logo text.
     */
    @Description(useJavaDoc = true)
    @Step("Get logo text")
    @Test(expected = LogoNotFoundException.class)
    public void errorGetLogoTextTest() {


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

}
