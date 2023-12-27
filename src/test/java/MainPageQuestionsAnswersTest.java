import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class) // запуск с параметризацией
public class MainPageQuestionsAnswersTest {
    WebDriver driver; // объявление драйвера
    private final int index; // объявление значения для локаторов вопросов и ответов
    private final String expected; // объявление значения текста ОР
    public MainPageQuestionsAnswersTest(int index, String expected) {
        this.index = index;
        this.expected = expected;
    } // инициализация переменных ОР и локторов вопросов и ответов
    @Parameterized.Parameters // параметры для теста
    public static Object[][] getDataTest() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
    public void mainPageQuestionsAnswersTest() {
        MainPageElements mainPage = new MainPageElements(driver); // создание экземпляра главной страницы
        mainPage.clickAcceptCookiesButton(); // принимаем куки
        mainPage.scrollAndClickQuestion(index); // скролл и клик по вопросу
        assertEquals(expected, mainPage.getTextAnswer(index)); // сравнение текста ответа на вопрос с индексом из параметров
    }

    @After
    public void tearDown() {
        driver.quit();
    } // закрываем браузер
}
