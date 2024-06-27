package parabank;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage {
    WebDriver driver;

    private By usuarioId = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By botonLogin = By.xpath("//input[@value='Log In']");
    private By openNewAccount = By.linkText("Open New Account");
    private By tipoCuentaId = By.id("type");
    private By botonSubmit = By.xpath("//INPUT[@type='submit']");

    public OpenAccountPage(WebDriver driver, WebDriverWait wait) {
        super();
        this.driver = driver;
    }
    private By cuentaExitosa = By.xpath("//P[text()='Congratulations, your account is now open.']");
    WebDriver driver, WebDriverWait wait

    public boolean isAccountOpenSuccessMessageDisplayed() {
        return driver.getPageSource().contains("Congratulations, your account is now open.");
    }
}
