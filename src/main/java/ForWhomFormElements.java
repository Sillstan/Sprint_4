import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ForWhomFormElements {
    WebDriver driver; // объявление драйвера
    public ForWhomFormElements(WebDriver driver) {
        this.driver = driver;
    } // инициализация драйвера
    private final By userNameField = By.xpath(".//*[@placeholder='* Имя']"); // поле "Имя"
    private final By userSurnameField = By.xpath(".//*[@placeholder='* Фамилия']"); //поле "Фамилия"
    private final By userAddressField = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']"); // поле "Адрес"
    private final By userMetroField = By.xpath(".//*[@placeholder='* Станция метро']"); // поле "Метро"
    private final String stationName = ".//*[text()='%s']"; // xpath для станции метро
    private final By userPhoneNumberField = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']"); // поле "Телефон"
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // кнопка "Далее"
    private final By errorNameField = By.xpath(".//*[text()='Введите корректное имя']"); // ошибка в поле имя
    private final By errorSurnameField = By.xpath(".//*[text()='Введите корректную фамилию']"); // ошибка в поле фамилия
    private final By errorAddressField = By.xpath(".//*[text()='Введите корректный адрес']"); // ошибка в поле адрес
    private final By errorMetroField = By.xpath(".//*[text()='Выберите станцию']"); // ошибка в поле метро
    private final By errorPhoneNumberField = By.xpath(".//*[text()='Выберите станцию']"); // ошибка в поле телефон
    public void fillInTheFieldsFoWhomForm(String name, String surname, String address, String station, String phoneNumber) {
        driver.findElement(userNameField).sendKeys(name);
        driver.findElement(userSurnameField).sendKeys(surname);
        driver.findElement(userAddressField).sendKeys(address);
        driver.findElement(userMetroField).click();
        scrollAndClickMetroStation(driver, station);
        driver.findElement(userPhoneNumberField).sendKeys(phoneNumber);
    } // заполнение полей формы данными
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    } // клик по кнопке далее
    public void scrollAndClickMetroStation(WebDriver driver, String station) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(stationName, station))));
        actions.click(driver.findElement(By.xpath(String.format(stationName, station))));
        actions.perform();
    } // скролл и клик по станции метро
    public boolean errorNameFieldIsDisplayed() {
        return driver.findElement(errorNameField).isDisplayed();
    } // проверка появления сообщения об ошибке в поле имя
    public boolean errorSurnameFieldIsDisplayed() {
        return driver.findElement(errorSurnameField).isDisplayed();
    } // проверка появления сообщения об ошибке в поле фамилия
    public boolean errorAddressFieldIsDisplayed() {
        return driver.findElement(errorAddressField).isDisplayed();
    } // проверка появления сообщения об ошибке в поле адрес
    public boolean errorMetroFieldIsDisplayed() {
        return driver.findElement(errorMetroField).isDisplayed();
    } // проверка появления сообщения об ошибке в поле адрес
    public boolean errorPhoneNumberFieldIsDisplayed() {
        return driver.findElement(errorPhoneNumberField).isDisplayed();
    } // проверка появления сообщения об ошибке в поле телефон
}
