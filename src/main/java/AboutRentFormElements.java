import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentFormElements {
    WebDriver driver;
    public AboutRentFormElements(WebDriver driver) {
        this.driver = driver;
    }
    private final By whenToDeliverField = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.className("Dropdown-arrow");
    private final String rentalPeriod = ".//*[text()='%s']";
    private final String scooterColor = ".//*[text()='%s']";
    private final By commentField = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    private final By editOrderButtonFinal = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Заказать')]");
    private final By yesButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");
    private final By acceptOrderHeader = By.xpath(".//div[text()='Заказ оформлен']");
    public void fillInTheFieldsAboutRentForm(String date, String rentalPeriodValue, String scooterColorValue, String comment) {
        driver.findElement(whenToDeliverField).sendKeys(date);
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(rentalPeriod, rentalPeriodValue))).click();
        driver.findElement(By.xpath(String.format(scooterColor, scooterColorValue))).click();
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickEditOrderButtonFinal() {
        driver.findElement(editOrderButtonFinal).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public boolean isAcceptOrderHeaderDisplayed() {
        return driver.findElement(acceptOrderHeader).isDisplayed();
    }
}
