import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait =null;
   public static Actions actions =null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
   @BeforeMethod
   @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       driver  = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wait =new WebDriverWait(driver,Duration.ofSeconds(10));
actions =new Actions(driver);
       url =BaseURL;
       driver.get(url);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void navigateLoginPage(){
        //driver.get(url);

    }

    public void provideEmail(String email){
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password){
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void clickSubmit(){
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit  =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }


}