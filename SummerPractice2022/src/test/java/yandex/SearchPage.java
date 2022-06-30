package yandex;

import core.BaseSeleniumPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import properties.MyProperties;

public class SearchPage extends BaseSeleniumPage {

//    private final By str = By.id("id");
    @FindBy(id = "text")
    private WebElement textInput;

    @FindBy(className = "button_size_search")
    private WebElement searchButton;

    public SearchPage(){
        driver.get(MyProperties.URL);
        PageFactory.initElements(driver, this);
    }

    public SearchPage doSearch(String searchText){
        textInput.click();
        textInput.sendKeys(searchText);
        searchButton.click();
        return this;

    }
}
