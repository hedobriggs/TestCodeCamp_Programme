package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashBoardPage {
    // Create a WebDriver object for the class
    private WebDriver driver;
    // Constructor for the Dashboard page
    public DashBoardPage(WebDriver driver)
    {
        this.driver = driver;
    }
    // Locate elements
    private By welcomeAdmin = By.cssSelector("#branding a:nth-child(2)");
    private By logOut = By.linkText("Logout");
    // Functions to interact with the element
    public void clickWelcomeAdmin() throws InterruptedException
    {
        // Wait for 10 seconds before executing the action
        Thread.sleep(10000);
        driver.findElement(welcomeAdmin).click();
    }
    public LoginPage clickLogout() throws InterruptedException
    {
        // Wait for 5 seconds before executing the action
        Thread.sleep(5000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);
    }
}