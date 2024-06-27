package parabank.frontend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parabank.AccountActivityPage;
import parabank.BasePage;

public class testAccountActivity {

    private WebDriver driver;
    BasePage homePage;
    AccountActivityPage accountActivityPage;

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
    public void testAccountActivity() {
        driver.findElement(By.linkText("Accounts Overview")).click();

        WebElement balanceInfo = driver.findElement(By.xpath("//*[contains(text(), '*Balance includes deposits that may be subject to holds')]"));
        Assert.assertTrue(balanceInfo.isDisplayed(), "Account overview balance info is not visible.");

        driver.findElement(By.linkText("12345")).click(); // Click on a specific account link

        WebElement accountDetailsText = driver.findElement(By.xpath("//*[contains(text(), 'Account Details')]"));
        Assert.assertTrue(accountDetailsText.isDisplayed(), "Account details page is not visible.");

        driver.findElement(By.id("month")).sendKeys("All");
        driver.findElement(By.id("transactionType")).sendKeys("All");
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        WebElement accountActivity = driver.findElement(By.xpath("//*[contains(text(), 'Activity for all months and types')]"));
        Assert.assertTrue(accountActivity.isDisplayed(), "Account activity is not visible.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
