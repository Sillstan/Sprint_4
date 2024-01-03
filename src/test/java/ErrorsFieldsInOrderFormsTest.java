import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ErrorsFieldsInOrderFormsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        /*WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().fullscreen();
    }

    @Test
    public void errorsFieldsInForWhomFormTest() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickAcceptCookiesButton();
        mainPage.clickEditOrderButtonHeader();
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver);
        forWhomForm.clickNextButton();
        Assert.assertTrue("Ошибка в поле Имя не появилась", forWhomForm.errorNameFieldIsDisplayed());
        Assert.assertTrue("Ошибка в поле Фамилия не появилась", forWhomForm.errorSurnameFieldIsDisplayed());
        Assert.assertTrue("Ошибка в поле Адрес не появилась", forWhomForm.errorAddressFieldIsDisplayed());
        Assert.assertTrue("Ошибка в поле Метро не появилась", forWhomForm.errorMetroFieldIsDisplayed());
        Assert.assertTrue("Ошибка в поле Телефон не появилась", forWhomForm.errorPhoneNumberFieldIsDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
