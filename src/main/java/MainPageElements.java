import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPageElements {
    WebDriver driver;
    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }
    private final By acceptCookiesButton = By.id("rcc-confirm-button");
    private final By editOrderButtonHeader = By.className("Button_Button__ra12g");
    private final By editOrderButtonDown = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']");
    private final String questionId = "accordion__heading-%d";
    private final String answerId = "accordion__panel-%d";
    private final By logoScooter = By.className("Header_LogoScooter__3lsAR");
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");
    private final By statusOfOrderButton = By.className("Header_Link__1TAG7");
    private final By statusOfOrderField = By.xpath(".//*[@placeholder='Введите номер заказа']");
    private final By goButton = By.xpath(".//*[text()='Go!']");
    private final By imageNotFoundOrder = By.xpath(".//img[@alt='Not found']");
    public void clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
    }
    public void clickEditOrderButtonHeader() {
        driver.findElement(editOrderButtonHeader).click();
    }
    public String getTextAnswer(int index) {
        return driver.findElement(By.id(String.format(answerId, index))).getText();
    }
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    public void scrollAndClickQuestion(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id(String.format(questionId, index))));
        actions.click(driver.findElement(By.id(String.format(questionId, index))));
        actions.perform();
    }
    public void scrollAndClickEditOrderButtonDown() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(editOrderButtonDown));
        actions.click(driver.findElement(editOrderButtonDown));
        actions.perform();
    }
    public void clickStatusOfOrderButton() {
        driver.findElement(statusOfOrderButton).click();
    }
    public void clickAndSendKeyToStatusOfOrderField(String numberOfOrder) {
        driver.findElement(statusOfOrderField).click();
        driver.findElement(statusOfOrderField).sendKeys(numberOfOrder);
    }
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }
    public boolean getStatusNotFoundOrder() {
        return driver.findElement(imageNotFoundOrder).isDisplayed();
    }
}
