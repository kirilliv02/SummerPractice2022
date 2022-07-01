package yandex;

import core.BaseSeleniumTest;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

public class Test2 extends BaseSeleniumTest {
    @Test
    public void errorGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("яндекс"));
    }
}
