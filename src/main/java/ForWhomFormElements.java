import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ForWhomFormElements {
    WebDriver driver;
    public ForWhomFormElements(WebDriver driver) {
        this.driver = driver;
    }
    private final By userNameField = By.xpath(".//*[@placeholder='* Имя']");
    private final By userSurnameField = By.xpath(".//*[@placeholder='* Фамилия']");
    private final By userAddressField = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    private final By userMetroField = By.xpath(".//*[@placeholder='* Станция метро']");
    private final String stationName = ".//*[text()='%s']"; // xpath для станции метро
    private final By userPhoneNumberField = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By errorNameField = By.xpath(".//*[text()='Введите корректное имя']");
    private final By errorSurnameField = By.xpath(".//*[text()='Введите корректную фамилию']");
    private final By errorAddressField = By.xpath(".//*[text()='Введите корректный адрес']");
    private final By errorMetroField = By.xpath(".//*[text()='Выберите станцию']");
    private final By errorPhoneNumberField = By.xpath(".//*[text()='Выберите станцию']");
    public void fillInTheFieldsFoWhomForm(String name, String surname, String address, String station, String phoneNumber) {
        driver.findElement(userNameField).sendKeys(name);
        driver.findElement(userSurnameField).sendKeys(surname);
        driver.findElement(userAddressField).sendKeys(address);
        driver.findElement(userMetroField).click();
        scrollAndClickMetroStation(driver, station);
        driver.findElement(userPhoneNumberField).sendKeys(phoneNumber);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void scrollAndClickMetroStation(WebDriver driver, String station) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(String.format(stationName, station))));
        actions.click(driver.findElement(By.xpath(String.format(stationName, station))));
        actions.perform();
    }
    public boolean errorNameFieldIsDisplayed() {
        return driver.findElement(errorNameField).isDisplayed();
    }
    public boolean errorSurnameFieldIsDisplayed() {
        return driver.findElement(errorSurnameField).isDisplayed();
    }
    public boolean errorAddressFieldIsDisplayed() {
        return driver.findElement(errorAddressField).isDisplayed();
    }
    public boolean errorMetroFieldIsDisplayed() {
        return driver.findElement(errorMetroField).isDisplayed();
    }
    public boolean errorPhoneNumberFieldIsDisplayed() {
        return driver.findElement(errorPhoneNumberField).isDisplayed();
    }
}
