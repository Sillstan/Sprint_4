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
    private final String numberOfOrder = "100500";
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
    public void nonExistentOrderTest() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickAcceptCookiesButton();
        mainPage.clickStatusOfOrderButton();
        mainPage.clickAndSendKeyToStatusOfOrderField(numberOfOrder);
        mainPage.clickGoButton();
        Assert.assertTrue("Система не пишет, что заказа не существует", mainPage.getStatusNotFoundOrder());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
