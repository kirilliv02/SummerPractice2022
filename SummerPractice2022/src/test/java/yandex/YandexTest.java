package yandex;

import core.BaseSeleniumTest;
import org.junit.Test;

public class YandexTest extends BaseSeleniumTest {

    @Test
    public void searchTest(){
        String text = "стеклопакет Казань";

        SearchPage searchPage = new SearchPage();

        searchPage.doSearch(text);
    }
}
