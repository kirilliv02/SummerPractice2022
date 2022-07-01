package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseSeleniumTest {
    protected WebDriver webDriver;

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        BaseSeleniumPage.setDriver(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }

}
