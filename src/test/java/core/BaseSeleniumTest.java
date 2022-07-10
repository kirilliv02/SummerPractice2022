package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import logger.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Base abstract test
 */
public abstract class BaseSeleniumTest {

    /**
     * Launches the web interface
     */
    protected WebDriver webDriver;
    /**
     * The ErrorCollector rule allows execution of a test to continue after the first problem is found
     */
    @Rule
    public final ErrorCollector collector = new ErrorCollector();



    /**
     * Initializes webdriver and configure them
     */
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        BaseSeleniumPage.setDriver(webDriver);


    }

    /**
     * Close webdriver and close browser
     */
    @After
    public void tearDown() {
        webDriver.quit();
        Logger.saveLogs(collector, this.getClass().getSimpleName());
    }

    @Attachment(value = "Description")
    public String addDescription(String description){
        return description;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] addScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }


}
