package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

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
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();

        BaseSeleniumPage.setDriver(webDriver);
    }

    /**
     * Close webdriver and close browser
     */
    @After
    public void tearDown()  {
        webDriver.quit();
    }

}
