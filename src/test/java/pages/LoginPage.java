package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
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
}
