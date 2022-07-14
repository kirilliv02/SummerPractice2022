package listeners;

import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.Description;
import utils.AllureDescriptionFromJavadocViewer;

public class Listener extends AllureJunit4 {


    @Override
    public void testFinished(Description description) throws Exception {
        super.testFinished(description);
        AllureDescriptionFromJavadocViewer.updateFiles();
    }
}
