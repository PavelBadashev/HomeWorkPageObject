package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbsBasePage{
    private final By usernameLocation = By.id("username");
    private final By emailLocation = By.id("email");
    private final By passwordLocation = By.id("password");
    private final By birthdateLocation = By.id("birthdate");
    private final By confirm_passwordLocation = By.id("confirm_password");
    private final By language_levelLocation = By.id("language_level");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage enterUserName(String username){
        driver.findElement(usernameLocation).sendKeys(username);
        return this;
    }

    public MainPage enterEmail(String email) {
        driver.findElement(emailLocation).sendKeys(email);
        return this;
    }

    public MainPage enterPassword(String password) {
        driver.findElement(passwordLocation).sendKeys(password);
        return this;
    }

    public MainPage enterBirthdate(String birthdate) {
        driver.findElement(birthdateLocation).sendKeys(birthdate);
        return this;
    }

    public MainPage enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirm_passwordLocation).sendKeys(confirmPassword);
        return this;
    }

    public MainPage enterLanguageLevel(String languageLevel) {
        new Select(driver.findElement(language_levelLocation)).selectByValue(languageLevel);
        return this;
    }

    public MainPage clickSubmit() {
        driver.findElement(By.cssSelector("input[type=submit]")).click();
        return this;
    }
}
