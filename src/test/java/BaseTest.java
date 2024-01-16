import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public WebDriver driver;

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
   // public WebDriver driver = null;

    //public String url = "https://qa.koel.app/";
    //private  String BaseURL = "https://qa.koel.app/";
    //public String registrationlink = "";
   public WebDriverWait wait =null;
    //public static WebDriver driver = null;
   public static String url =null;
    //public static final ThreadLocal <WebDriver> threadDriver = new ThreadLocal<>();
   public static Actions actions = null;

    //@BeforeSuite
   // static void setupClass() {
        //WebDriverManager.chromedriver().setup();
   // }
   @BeforeMethod
   @Parameters({"baseURL"})
   public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
       THREAD_LOCAL.set(pickBrowser(System.getProperty("browser")));
       THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       THREAD_LOCAL.get().manage().window().maximize();
       THREAD_LOCAL.get().manage().deleteAllCookies();
       getThreadLocal().get(baseURL);
       System.out.println(
               "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

   }

   /*public void setupBrowser(String BaseURL) throws MalformedURLException{
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateLoginPage(BaseURL);
   }
    public static WebDriver getDriver(){
        return threadDriver.get();

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
            case "cloud": return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver=new ChromeDriver(options);
        }

    }


   /*@BeforeMethod
    public void launchBrowser(String BaseURL){

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       driver  = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wait =new WebDriverWait(driver,Duration.ofSeconds(10));
actions =new Actions(driver);
       url =BaseURL;
       driver.get(url);
    }*/

   /*@AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @AfterMethod
    public void tearDown() {
    threadDriver.get().close();
    threadDriver.remove();
    }*/
    public void navigateLoginPage(String BaseURL){
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
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "valyamosy";
        String authkey = "9Sli6kMdZJKWZVg0WIvNLTt4FMaTDy8KZeLtfp8hc9xFoIe2oV";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.2.127.17:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-edge":
                capabilities.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                optionsChrome.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}

/*public static WebDriver lambdaTest() throws MalformedURLException {
        String username ="valyamosy";
        String authkey = "9Sli6kMdZJKWZVg0WIvNLTt4FMaTDy8KZeLtfp8hc9xFoIe2oV";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
    caps.setCapability("browsername", "Chrome");
    caps.setCapability("version", "121.0");
    caps.setCapability("resolution", "1280x1024");
    caps.setCapability("build", "TestNG with Java");
    caps.setCapability("name", BaseTest.class.getName());
    caps.setCapability("plugin", "java testNG");
        return new RemoteWebDriver(new URL("https://"+username+":" +authkey+  hub),caps);
}*/



//}