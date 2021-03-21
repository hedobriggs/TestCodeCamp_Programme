package Setup;
import PageObject.DashBoardPage;
import PageObject.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupTest {
    // Create a WebDriver Object
    private WebDriver driver;
    // Create LoginPage object
    protected LoginPage loginPage;
    // Create Dashboard object
    protected DashBoardPage dashboardpage;
    @BeforeTest
    public void setUp()
    {
        // Selenium WebDriver needs this executable in order to know which browser to run your test
        // Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Instantiate the Chrome WebDriver object
        driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Get the application URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        // Instantiate the Login page
        loginPage = new LoginPage(driver);
    }
    // "close" will only close the window or tab but "quit" ends the browser
    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}