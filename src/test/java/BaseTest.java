import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    public String url = "https://qa.koel.app/";
    //public String registrationlink = "";
    public WebDriverWait wait =null;
   Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
   @BeforeMethod
   @Parameters({"BaseURL"})

   public void setupBrowser(String BaseURL) throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateLoginPage(BaseURL);
   }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://10.0.0.206:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case"grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browser", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case"grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver=new ChromeDriver(options);
        }

    }

    public static WebDriver getDriver(){
        return threadDriver.get();

   }
    /*public void launchBrowser(String BaseURL){

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       driver  = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wait =new WebDriverWait(driver,Duration.ofSeconds(10));
actions =new Actions(driver);
       url =BaseURL;
       driver.get(url);
    }*/
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