import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class MakeAnOrderTest {
    WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriodValue;
    private final String scooterColorValue;
    private final String comment;
    public MakeAnOrderTest(String name, String surname, String address, String station, String phoneNumber, String date, String rentalPeriodValue, String scooterColorValue, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriodValue = rentalPeriodValue;
        this.scooterColorValue = scooterColorValue;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataTest() {
        return new Object[][] {
                {"Добрыня", "Никитич", "ул. Ленина, 165", "Лихоборы", "89533333333", "26.12.2023", "сутки", "серая безысходность", "Звонок не работает"},
                {"Илья", "Муромец", "ул. Сталина, 123", "Красносельская", "89522222222", "28.01.2024", "трое суток", "чёрный жемчуг", "Злая собака"},
                {"Алеша", "Попович", "ул. Билимбаевская, 15", "Чистые пруды", "89522222215", "28.12.2023", "двое суток", "чёрный жемчуг", ""},
                {"Соловей", "Разбойник", "ул. Папина, 1", "Сокол", "89545622222", "30.12.2023", "четверо суток", "серая безысходность", "Атстань"},
        };
    }

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
    public void makeAnOrderTestWithEditOrderButtonHeader() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickAcceptCookiesButton();
        mainPage.clickEditOrderButtonHeader();
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver);
        forWhomForm.fillInTheFieldsFoWhomForm(name, surname, address, station, phoneNumber);
        forWhomForm.clickNextButton();
        AboutRentFormElements aboutRentForm = new AboutRentFormElements(driver);
        aboutRentForm.fillInTheFieldsAboutRentForm(date, rentalPeriodValue, scooterColorValue, comment);
        aboutRentForm.clickEditOrderButtonFinal();
        aboutRentForm.clickYesButton();
        Assert.assertTrue("Подтверждение заказа не появилось", aboutRentForm.isAcceptOrderHeaderDisplayed());
    }

    @Test
    public void makeAnOrderTestWithEditOrderButtonDown() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickAcceptCookiesButton();
        mainPage.scrollAndClickEditOrderButtonDown();
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver);
        forWhomForm.fillInTheFieldsFoWhomForm(name, surname, address, station, phoneNumber);
        forWhomForm.clickNextButton();
        AboutRentFormElements aboutRentForm = new AboutRentFormElements(driver);
        aboutRentForm.fillInTheFieldsAboutRentForm(date, rentalPeriodValue, scooterColorValue, comment);
        aboutRentForm.clickEditOrderButtonFinal();
        aboutRentForm.clickYesButton();
        Assert.assertTrue("Подтверждение заказа не появилось", aboutRentForm.isAcceptOrderHeaderDisplayed());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
