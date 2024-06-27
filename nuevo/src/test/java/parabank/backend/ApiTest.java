package parabank.backend;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.extentReports.ExtentFactory;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ApiTest {
    private static ExtentReports extent;
    private static ExtentSparkReporter info = new ExtentSparkReporter("target/ExtentReport.html");

    private String urlBase = "https://parabank.parasoft.com/parabank/services_proxy/bank/";
    private String customerId= "54321";
    private String accountId= "65432";
    private String username = "johndoe";
    private String password = "password";

    @BeforeAll
    public static void setUp() {
        extent = new ExtentReports();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void waitBeforeTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    @Order(1)
    public void registroTest() {
        given()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @Order(2)
    public void crearCuentaTest() {
        String response = given()
                .get("https://parabank.parasoft.com/parabank/services/bank/customers/" + customerId + "/accounts")
                .then()
                .statusCode(200)
                .log().all()
                .extract().asString();

        accountId = response.substring(response.indexOf("<id>") + "<id>".length(), response.indexOf("</id>"));
        System.out.println("ID de la Cuenta: " + accountId);
    }

    @Test
    @Order(3)
    public void nuevaCuentaTest() {
        given()
                .auth().basic(username, password)
                .post(urlBase + "createAccount?customerId=" + customerId + "&newAccountType=1&fromAccountId=" + accountId)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @Order(4)
    public void resumenCuentaTest() {
        given()
                .get("https://parabank.parasoft.com/parabank/overview.html")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    @Order(5)
    public void transferenciaFondosTest() {
        String amount = "1000";
        given()
                .auth().basic(username, password)
                .post(urlBase + "transfer?fromAccountId=" + accountId + "&toAccountId=15453&amount=" + amount)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    @Order(6)
    public void actividadCuentaTest() {
        given()
                .auth().basic(username, password)
                .get(urlBase + "accounts/" + accountId + "/transactions/month/All/type/All")
                .then()
                .statusCode(200)
                .log().all();
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
    }
}