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
import parabank.FundTransferPage;

public class testFundTransfer {
    private WebDriver driver;
    BasePage homePage;
    FundTransferPage fundTransferPage;

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
    public void testFundTransfer() {
        driver.findElement(By.linkText("Transfer Funds")).click();

        WebElement transferFundsText = driver.findElement(By.xpath("//*[contains(text(), 'Transfer Funds')]"));
        Assert.assertTrue(transferFundsText.isDisplayed(), "Transfer Funds page is not visible.");

        driver.findElement(By.id("amount")).sendKeys("100");
        driver.findElement(By.id("fromAccountId")).sendKeys("12345");
        driver.findElement(By.id("toAccountId")).sendKeys("67890");
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(), 'Transfer Complete!')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Transfer was not completed successfully.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
