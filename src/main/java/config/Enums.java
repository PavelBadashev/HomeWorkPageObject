package config;

import java.util.Properties;

public class Enums {
    private static final Properties properties = new Properties();

    public static String getUrl() {
        return properties.getProperty("url", "https://otus.home.kartushin.su/form.html");
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }
}
