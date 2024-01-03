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
    WebDriver driver;
    private final String expectedUrlScooter = "https://qa-scooter.praktikum-services.ru/";
    private final String expectedUrlYandex = "https://ya.ru/";

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
    public void urlTestScooter() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickLogoScooter();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        assertEquals(expectedUrlScooter, driver.getCurrentUrl());
    }

    @Test
    public void urlTestYandex() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickLogoYandex();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        assertEquals(expectedUrlYandex, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
