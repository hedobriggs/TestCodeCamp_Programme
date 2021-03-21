import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class facebookSignIn {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //launch the chromedrviver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://web.facebook.com/?_rdc=1&_rdr");
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        //click on the username field and input a valid username ""
        driver.findElement(By.id("email")).sendKeys("hedobriggs@gmail.com");
        //click on the password field and input a valid password "admn123."
        driver.findElement(By.id("pass")).sendKeys("Excellent101");
        //Click on the Login/Signin button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);

        if (driver.getCurrentUrl().contains("https://web.facebook.com/")) {
            System.out.println("PASSED - User has successfully loggin in");
        } else {
            System.out.println("FAILED - The user was unable to loggin");
        }
        Thread.sleep(5000);
    }

    @Test
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/i")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div")).click();
        if(driver.getCurrentUrl().contains("https://www.facebook.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(5000);

        if(driver.getCurrentUrl().contains("https://www.facebook.com/")){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        Thread.sleep(5000);
    }
    @AfterTest
    public void QuitBrowser(){driver.quit();}
}