package yandex.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.MyProperties;

public class SearchPage extends BaseSeleniumPage {

    @FindBy(className = "home-logo__default")
    private WebElement logoText;
    @FindBy(xpath = "//div[@class='search2__button']/button/span[@class='button__text']")
    private WebElement searchButtonText;

    @FindBy(className = "yabrowser-promo__text-link")
    private WebElement downloadBrowserLinkText;

    @FindBy(className = "search2__placeholder")
    private WebElement searchInputPlaceholderText;

    @FindBy(className = "geolink__reg")
    private WebElement cityNameText;

    public SearchPage() {
        driver.get(MyProperties.URL);
        PageFactory.initElements(driver, this);
    }

    public String getLogoText() {
        return logoText.getAttribute("aria-label");
    }

    public String getSearchButtonText() {
        return searchButtonText.getText();

    }

    public String getDownloadBrowserLinkText() {
        return downloadBrowserLinkText.getText();
    }

    public String getSearchInputPlaceholderText() {
        return searchInputPlaceholderText.getText();
    }

    public String getCityNameText() {
        return cityNameText.getText();
    }
}
