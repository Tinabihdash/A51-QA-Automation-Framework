package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators PageFactory
    @FindBy(css = "input[type='email']")
    WebElement emailTextField;
    @FindBy(css = "input[type='password']")
    WebElement passwordTextField;
    @FindBy(css = "button[type='submit']")
    WebElement submitLoginButton;
    @FindBy(css = "a#hel")
    private WebElement registrationlink;

   // public LoginPage(WebDriver,givenDriver){
       // super (givenDriver);
    //}

    //helper methods for PageFactory
    public void provideEmailToLogin(String email){

        emailTextField.sendKeys(email);
    }
    public void providePasswordToLogin(String password) {

        passwordTextField.sendKeys(password);
    }

    public void clickSubmitToLogin() {

        submitLoginButton.click();
    }

    //Locators

    By emailField = By.cssSelector("input[type='email']");

    By passwordField =By.cssSelector("input[type='password']");
    By submit =By.cssSelector("button[type='submit']");

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submit).click();
    }
    public void login(){
        provideEmail("valentyna.bihdash@testpro.io");
        providePassword("TestTest1!");
        clickSubmit();
    }
    public  WebElement getRegistrationLink(){
        return registrationlink;
    }
}

