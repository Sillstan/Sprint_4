import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPageElements {
    WebDriver driver; //объявление драйвера
    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    } //инициализация драйвера
    private final By acceptCookiesButton = By.id("rcc-confirm-button"); // кнопка "принять куки"
    private final By editOrderButtonHeader = By.className("Button_Button__ra12g"); //кнопка "Заказать" в хидере
    private final By editOrderButtonDown = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']"); // кнопка заказать внизу страницы
    private final String questionId = "accordion__heading-%d"; // переменная для локаторов панели вопросов
    private final String answerId = "accordion__panel-%d"; // переменная для локаторов панели ответов
    private final By logoScooter = By.className("Header_LogoScooter__3lsAR"); // лого самокат в хидере
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI"); // лого Яндекс в хидере
    private final By statusOfOrderButton = By.className("Header_Link__1TAG7"); // кнопка статус заказа в хидере
    private final By statusOfOrderField = By.xpath(".//*[@placeholder='Введите номер заказа']"); //поле для ввода номера заказа
    private final By goButton = By.xpath(".//*[text()='Go!']"); // кнопка го
    private final By imageNotFoundOrder = By.xpath(".//img[@alt='Not found']"); // изображение заказ не найден
    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    } // клик по кнопке принять куки
    public void clickEditOrderButtonHeader() {
        driver.findElement(editOrderButtonHeader).click();
    } // клик по верхней кнопке заказать
    public String getTextAnswer(int index) {
        return driver.findElement(By.id(String.format(answerId, index))).getText();
    } // взять текст из ответа с переменным локатором
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    } // клик по лого скутер в хидере
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    } // клик по лого Яндекс в хидере
    public void scrollAndClickQuestion(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id(String.format(questionId, index))));
        actions.click(driver.findElement(By.id(String.format(questionId, index))));
        actions.perform();
    } // скролл до вопроса и клие по нему
    public void scrollAndClickEditOrderButtonDown() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(editOrderButtonDown));
        actions.click(driver.findElement(editOrderButtonDown));
        actions.perform();
    } // скролл до нижней кнопки заказать и клик по ней
    public void clickStatusOfOrderButton() {
        driver.findElement(statusOfOrderButton).click();
    } // клик по кнопке статус заказа в хидере
    public void clickAndSendKeyToStatusOfOrderField(String numberOfOrder) {
        driver.findElement(statusOfOrderField).click();
        driver.findElement(statusOfOrderField).sendKeys(numberOfOrder);
    } // клик и ввод данных в поле номер заказа
    public void clickGoButton() {
        driver.findElement(goButton).click();
    } // клик по кнопке го
    public boolean getStatusNotFoundOrder() {
        return driver.findElement(imageNotFoundOrder).isDisplayed();
    } // проверка появления сообщения об остутствии заказа с таким номером
}
