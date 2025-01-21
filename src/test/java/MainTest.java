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
        driver = new DriverFactory().getDriver("chrome");
    }

    @AfterEach
    void afterEach(){
        driver.close();
    }

    @ParameterizedTest
    @DisplayName("Проверка уровней владения языком")
    @ValueSource(strings = {"native", "advanced", "intermediate", "beginner"})
    void allLanguageTest(String language){
        MainPage fluentPage = new MainPage(driver);
        fluentPage.open();
        fluentPage
                .enterUserName("чувак")
                .enterPassword("пароль")
                .enterConfirmPassword("пароль1")
                .enterBirthdate("01/01/2000")
                .enterEmail("test123@test.com")
                .enterLanguageLevel(language);

        Assertions.assertTrue(fluentPage.checkPasswords(), "ASSERT: Пароль не совпадает!");
        fluentPage.clickSubmit();
    }
}
