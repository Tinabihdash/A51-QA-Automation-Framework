import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    public static void loginEmptyEmailPasswordTest(){
       LoginPage loginPage = new LoginPage(getThreadLocal());
        loginPage.provideEmail("");
        loginPage.providePassword("TestTest1!");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    //private static WebDriver getThreadLocal() {
    //}

    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
