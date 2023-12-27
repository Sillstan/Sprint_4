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
        WebDriverManager.chromedriver().setup(); // установка драйвера браузера хром
        driver = new ChromeDriver();
        /*WebDriverManager.firefoxdriver().setup(); // установка драйвера браузера фаерфокс
        driver = new FirefoxDriver();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ожидание при поиске локаторов
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открытие страницы в браузере
        driver.manage().window().fullscreen(); // фуллскрин для браузера
    }

    @Test
    public void errorsFieldsInForWhomFormTest() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickAcceptCookiesButton(); // принимаем куки
        mainPage.clickEditOrderButtonHeader(); // нажатие на верхнюю кнопку заказать
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver); // создание экземпляра страницы для кого самокат
        forWhomForm.clickNextButton(); // клик по кнопке далее
        Assert.assertTrue("Ошибка в поле Имя не появилась", forWhomForm.errorNameFieldIsDisplayed()); // проверка появилась ли ошибка в поле имя
        Assert.assertTrue("Ошибка в поле Фамилия не появилась", forWhomForm.errorSurnameFieldIsDisplayed()); // проверка появилась ли ошибка в поле фамилия
        Assert.assertTrue("Ошибка в поле Адрес не появилась", forWhomForm.errorAddressFieldIsDisplayed()); // проверка появилась ли ошибка в поле адрес
        Assert.assertTrue("Ошибка в поле Метро не появилась", forWhomForm.errorMetroFieldIsDisplayed()); // проверка появилась ли ошибка в поле метро
        Assert.assertTrue("Ошибка в поле Телефон не появилась", forWhomForm.errorPhoneNumberFieldIsDisplayed()); // проверка появилась ли ошибка в поле телефон
    }

    @After
    public void tearDown() {
        driver.quit();
    } // закрываем браузер
}
