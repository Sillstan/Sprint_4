import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class NonExistentOrderTest {
    WebDriver driver; // объявление драйвера
    private final String numberOfOrder = "100500"; // тестовое значение номера заказа
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
    public void nonExistentOrderTest() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickAcceptCookiesButton(); // принимаем куки
        mainPage.clickStatusOfOrderButton(); // клик по кнопке статус заказа
        mainPage.clickAndSendKeyToStatusOfOrderField(numberOfOrder); // клик и ввод данных в поле номер заказа
        mainPage.clickGoButton(); // клик по кнопке го
        Assert.assertTrue("Система не пишет, что заказа не существует", mainPage.getStatusNotFoundOrder()); // прояверяем появилось ли сообщение о том что заказ с таким номером не найден
    }

    @After
    public void tearDown() {
        driver.quit();
    } // закрываем браузер
}
