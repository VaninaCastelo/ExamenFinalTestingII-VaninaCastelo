package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountActivityPage extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By usuarioId = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By botonLogin = By.xpath("//input[@value='Log In']");
    private By accountsOverview = By.linkText("Accounts Overview");
    private By mensajeBalance = By.xpath("//TD[@colspan='3'][text()='*Balance includes deposits that may be subject to holds']");
    private By accountNumber = By.linkText("15564");
    private By tituloDetalleCuenta = By.xpath("//H1[@class='title'][text()='Account Details']");
    private By actividadPeriodoId = By.id("month");
    private By tipoId = By.id("transactionType");
    private By botonSubmit = By.xpath("//INPUT[@type='submit']");

    public AccountActivityPage(WebDriver driver, WebDriverWait wait) {
        super();
        this.driver = driver;
        this.wait = wait;
    }

    public void escribirUsuario(String usuario) {
        sendText(usuario, usuarioId);
    }

    public void escribirPassword(String pass) {
        sendText(pass, password);
    }

    public void clickBotonLogin() {
        this.clickear(botonLogin);
    }

    public void clickAccountsOverview() {
        this.clickear(accountsOverview);
    }

    public void clickAccountNumber() {
        this.clickear(accountNumber);
    }

    public void seleccionarPeriodoActividad() {
        Select select = new Select(driver.findElement(actividadPeriodoId));
        select.selectByVisibleText("All");
    }

    public void seleccionarTipoActividad() {
        Select select = new Select(driver.findElement(tipoId));
        select.selectByVisibleText("All");
    }

    public void clickSubmit() {
        this.clickear(botonSubmit);
    }
}

