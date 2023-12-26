import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentFormElements {
    WebDriver driver; // объявление драйвера
    public AboutRentFormElements(WebDriver driver) {
        this.driver = driver;
    } // инициализация драйвера
    private final By whenToDeliverField = By.xpath(".//*[@placeholder='* Когда привезти самокат']"); // поле "Дата доставки"
    private final By rentalPeriodField = By.className("Dropdown-arrow"); // поле "Срок аренды"
    private final String rentalPeriod = ".//*[text()='%s']"; // xpath для выпадающего списка со сроком аренды
    private final String scooterColor = ".//*[text()='%s']"; // xpath для цвета самоката
    private final By commentField = By.xpath(".//*[@placeholder='Комментарий для курьера']"); // поле "Комментарий"
    private final By editOrderButtonFinal = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Заказать')]"); // кнопка "Заказать"
    private final By yesButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']"); // кнопка "Да" во всплывающем окне "Хотите сделать заказ?"
    private final By acceptOrderHeader = By.xpath(".//div[text()='Заказ оформлен']"); // заголовок во всплывающем окне "Заказ оформлен"
    public void fillInTheFieldsAboutRentForm(String date, String rentalPeriodValue, String scooterColorValue, String comment) {
        driver.findElement(whenToDeliverField).sendKeys(date);
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(rentalPeriod, rentalPeriodValue))).click();
        driver.findElement(By.xpath(String.format(scooterColor, scooterColorValue))).click();
        driver.findElement(commentField).sendKeys(comment);
    } // заполнение полей формы данными
    public void clickEditOrderButtonFinal() {
        driver.findElement(editOrderButtonFinal).click();
    } // клик по кнопке заказать
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    } // клик по кнопке да
    public boolean isAcceptOrderHeaderDisplayed() {
        return driver.findElement(acceptOrderHeader).isDisplayed();
    } // появление окна заказ оформлен
}
