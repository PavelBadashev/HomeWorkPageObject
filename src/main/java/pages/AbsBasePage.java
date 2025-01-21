package pages;

import config.Enums;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage {
    protected WebDriver driver;
    public final static String BASE_URL = Enums.getUrl();
//    public final static String BASE_URL = "https://otus.home.kartushin.su/form.html";

    public AbsBasePage(WebDriver driver){
        this.driver = driver;
    }

    public AbsBasePage open(){
            driver.get(BASE_URL);
            return this;
    }
}
