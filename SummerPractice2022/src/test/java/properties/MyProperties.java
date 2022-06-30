package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface MyProperties {
    Properties properties = getProperties();

    static Properties getProperties(){
        Properties prop = new Properties();
        try {
            prop.load(MyProperties.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    String URL = properties.getProperty("url");

}
