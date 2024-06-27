package parabank.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.BasePage;
import parabank.OpenAccountPage;

public class testOpenAccount {
    private WebDriver driver;
    BasePage basePage;
    OpenAccountPage openAccountPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Login
        driver.findElement(By.name("username")).sendKeys("johndoe");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Test
    public void testOpenNewAccount() {
        driver.findElement(By.linkText("Open New Account")).click();
        driver.findElement(By.id("type")).sendKeys("SAVINGS");
        driver.findElement(By.xpath("//input[@value='Open New Account']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Congratulations, your account is now open.')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Opening new account failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
