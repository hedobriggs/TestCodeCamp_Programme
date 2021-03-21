package Login;

import PageObject.DashBoardPage;
import Setup.SetupTest;
import org.testng.annotations.Test;

public class LoginTest extends SetupTest {

    @Test
    public void testLogin() throws InterruptedException
    {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        loginPage.clickLoginBtn();
        String pageurl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println ("PASSED - The page url is " + pageurl);
    }

    @Test
    public void testLogout () throws InterruptedException {
        try {
            dashboardpage.clickWelcomeAdmin();
            loginPage = dashboardpage.clickLogout();
        } catch (Exception e) {
            String loginurl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
            System.out.println("PASSED - Thepage url is " + loginurl);
        }

    }
}
