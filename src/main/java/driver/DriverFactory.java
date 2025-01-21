package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    public WebDriver driver;

    public WebDriver getDriver(String browserType) {
//        WebDriver driver;
        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                FirefoxOptions fireOption = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                EdgeOptions edge = new EdgeOptions();
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Неподдеживаемый браузер " + browserType);
        }
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
