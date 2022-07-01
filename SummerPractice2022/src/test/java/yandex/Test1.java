package yandex;

import core.BaseSeleniumTest;
import org.junit.Test;
import yandex.pages.SearchPage;

import static org.hamcrest.CoreMatchers.is;

public class Test1 extends BaseSeleniumTest {

    /**
     * Create a valid account.
     * @result Account will be persisted without any errors,
     *         and Account.getId() will no longer be <code>null</code>
     */
    @Test
    public void successGetLogoTextTest(){
        SearchPage searchPage = new SearchPage();
        String logoText = searchPage.getLogoText();
        collector.checkThat(logoText, is("Яндекс"));
    }
}
