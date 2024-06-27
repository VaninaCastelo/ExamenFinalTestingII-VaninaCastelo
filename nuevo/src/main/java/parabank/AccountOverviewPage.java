package parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage {

    private By accountSummaryLink = By.linkText("Resumen de cuentas");
    private By balanceInfoText = By.xpath("//*[contains(text(),'El saldo incluye depósitos que pueden estar sujetos a retenciones')]");

    public AccountOverviewPage(WebDriver) {
        super(driver);
    }

    public void clickAccountSummary() {
        clickear(accountSummaryLink);
    }

    public boolean isBalanceInfoDisplayed() {
        return driver.findElement(balanceInfoText).isDisplayed();
    }
}