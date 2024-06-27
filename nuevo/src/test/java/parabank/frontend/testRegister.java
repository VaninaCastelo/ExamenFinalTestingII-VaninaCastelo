package parabank.frontend;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.BasePage;
import parabank.RegisterPage;

import java.time.Duration;

public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;
    BasePage basePage;
    RegisterPage registerPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    public void testRegister() {
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Elm Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Anytown");
        driver.findElement(By.id("customer.address.state")).sendKeys("CA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("johndoe");
        driver.findElement(By.id("customer.password")).sendKeys("password");
        driver.findElement(By.id("repeatedPassword")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Registration failed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
