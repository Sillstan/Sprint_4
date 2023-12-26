import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UrlTest {
    WebDriver driver; // объявление драйвера
    private final String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/"; // объявление значения URL ОР при нажатии на самокат в хидере
    private final String expectedUrlYandex = "https://ya.ru/"; // объявление значения URL ОР при нажатии на Яндекс в хидере

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
    public void urlTestScooter() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickLogoScooter(); // клик по самокату в хидере
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        } // переход на новую вкладку, если таковая появилась
        assertEquals(expectedUrlScooter, driver.getCurrentUrl()); // сравнение фактического URL с ожидаемым
    }

    @Test
    public void urlTestYandex() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickLogoYandex(); // клик по Яндексу в хидере
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        } // переход на новую вкладку, если таковая появилась
        assertEquals(expectedUrlYandex, driver.getCurrentUrl()); // сравнение фактического URL с ожидаемым
    }

    @After
    public void tearDown() {
        driver.quit();
    } // закрываем браузер
}
