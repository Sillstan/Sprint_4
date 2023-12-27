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

@RunWith(Parameterized.class) // запуск с параметризацией
public class MakeAnOrderTest {
    WebDriver driver; // объявление драйвера
    private final String name; // объявление значения имени
    private final String surname; // объявление значения фамилии
    private final String address; // объявление значения адреса
    private final String station; // объявление значения станции
    private final String phoneNumber; // объявление значения номера телефона
    private final String date; // объявление значения даты
    private final String rentalPeriodValue; // объявление значения срока аренды
    private final String scooterColorValue; // объявление значения цвета
    private final String comment; // объявление значения комментария
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
    } // инициализация переменных

    @Parameterized.Parameters // параметры для теста
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
        WebDriverManager.chromedriver().setup(); // установка драйвера браузера хром
        driver = new ChromeDriver();
        /*WebDriverManager.firefoxdriver().setup(); // установка драйвера браузера фаерфокс
        driver = new FirefoxDriver();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // ожидание при поиске локаторов
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открытие страницы в браузере
        driver.manage().window().fullscreen(); // фуллскрин для браузера
    }

    @Test
    public void makeAnOrderTestWithEditOrderButtonHeader() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickAcceptCookiesButton(); // принимаем куки
        mainPage.clickEditOrderButtonHeader(); // нажатие на верхнюю кнопку заказать
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver); // создание экземпляра страницы для кого самокат
        forWhomForm.fillInTheFieldsFoWhomForm(name, surname, address, station, phoneNumber); // заполнение полей формы для кого самокат
        forWhomForm.clickNextButton(); // клик по кнопке далее
        AboutRentFormElements aboutRentForm = new AboutRentFormElements(driver); // создание экземпляра страницы про аренду
        aboutRentForm.fillInTheFieldsAboutRentForm(date, rentalPeriodValue, scooterColorValue, comment); // заполнение полей формы про аренду
        aboutRentForm.clickEditOrderButtonFinal(); // клик по кнопке заказать
        aboutRentForm.clickYesButton(); // клик по кнопке да
        Assert.assertTrue("Подтверждение заказа не появилось", aboutRentForm.isAcceptOrderHeaderDisplayed()); // проверка появления окна с подверждением оформления заказа
    }

    @Test
    public void makeAnOrderTestWithEditOrderButtonDown() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickAcceptCookiesButton(); // принимаем куки
        mainPage.scrollAndClickEditOrderButtonDown(); // скролл и нажатие на нижнюю кнопку заказать
        ForWhomFormElements forWhomForm = new ForWhomFormElements(driver); // создание экземпляра страницы для кого самокат
        forWhomForm.fillInTheFieldsFoWhomForm(name, surname, address, station, phoneNumber); // заполнение полей формы для кого самокат
        forWhomForm.clickNextButton(); // клик по кнопке далее
        AboutRentFormElements aboutRentForm = new AboutRentFormElements(driver); // создание экземпляра страницы про аренду
        aboutRentForm.fillInTheFieldsAboutRentForm(date, rentalPeriodValue, scooterColorValue, comment); // заполнение полей формы про аренду
        aboutRentForm.clickEditOrderButtonFinal(); // клик по кнопке заказать
        aboutRentForm.clickYesButton(); // клик по кнопке да
        Assert.assertTrue("Подтверждение заказа не появилось", aboutRentForm.isAcceptOrderHeaderDisplayed()); // проверка появления окна с подверждением оформления заказа
    }


    @After
    public void tearDown() {
        driver.quit();
    } // закрываем браузер
}
