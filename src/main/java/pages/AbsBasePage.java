package pages;

import config.Enums;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage {
    protected WebDriver driver;

    public AbsBasePage(WebDriver driver){
        this.driver = driver;
    }

    public AbsBasePage open(){
            driver.get(Enums.getUrl());
            return this;
    }
}
