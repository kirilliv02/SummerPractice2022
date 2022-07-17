package yandex.tests;

import core.BaseSeleniumTest;
import exceptions.LogoNotFoundException;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.junit.Assert;
import org.junit.Test;

/**
 * First test from task
 */
public class Test1 extends BaseSeleniumTest {

    /**
     * Successful check yandex logo text without any errors.
     */
    @Test
    @Description(useJavaDoc = true)
    @Step("Get logo text")
    public void successGetLogoTextTest() {
        String logoText = searchPage.getLogoText();

        try {
            Assert.assertEquals("Яндекс", logoText);
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
