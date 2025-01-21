import driver.DriverFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainTest {
    WebDriver driver;

    @BeforeEach
    void beforeEach() {
        driver = new DriverFactory().getDriver();
    }

    @AfterEach
    void afterEach(){
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest
    @DisplayName("Проверка соответствия паролей")
    @ValueSource(strings = {"пароль", "password"})
    void testPasswordValidation(String confirmPassword) throws InterruptedException {
        MainPage fluentPage = new MainPage(driver);
        String password = "пароль";
        fluentPage.open();
        fluentPage
                .enterUserName("логин5321")
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterBirthdate("01/01/2000")
                .enterEmail("test123@test.com")
                .enterLanguageLevel("native");
        Assertions.assertEquals(confirmPassword, password, "ASSERT: Пароль не совпадает!");
        fluentPage.clickSubmit();
    }
}
