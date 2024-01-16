import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public static void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("");
                loginPage.providePasswordToLogin("te$t$tudent");
              loginPage.clickSubmitToLogin();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

   /* @Test
    public static void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePasswordToLogin("te$t$tudent00");
        loginPage.clickSubmitToLogin();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePasswordToLogin("");
        loginPage.clickSubmitToLogin();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmail("demo9@class.com");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitToLogin();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }*/
    @Test
    public  void loginSuccessTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        loginPage.provideEmail("valentyna.bihdash@testpro.io");
        loginPage.providePassword("TestTest1!");
        loginPage.clickSubmit();
       //Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }


    //  @Test
    /*public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}




   // @Test
    /*public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }*/
}
