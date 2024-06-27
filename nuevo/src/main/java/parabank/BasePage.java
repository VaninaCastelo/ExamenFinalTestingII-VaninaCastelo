package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    public WebDriverWait wait;

    protected BasePage() {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    public void open(String url) {
        driver.get(url);
    }

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver.manage().window().maximize();
    }

    public WebElement findElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void sendText(String input, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(input);
    }

    public void sendKey(CharSequence input, By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).sendKeys(input);
    }

    public void clickear(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public String getText(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public void close() {
        driver.quit();
    }

}