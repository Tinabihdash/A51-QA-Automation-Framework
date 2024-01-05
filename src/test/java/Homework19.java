import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    private String baseUrl = "https://qa.koel.app/";

    @Test

    public void deletePlaylist(){
        String expectedPlaylistDeleteMessage = "Delete the playlist \"Val\"?";
        navigateLoginPage(baseUrl);
        provideEmail("valentyna.bihdash@testpro.io");
        providePassword("TestTest1!");
        clickSubmit();
        clickOnPlaylist();
        clickOnRedButton();
        //wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(deletelist(),expectedPlaylistDeleteMessage);

    }

    public void clickOnPlaylist() {
        //WebElement playlist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        WebElement playlist =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        playlist.click();
    }

    public void clickOnRedButton()  {
       // WebElement redButton = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button[2]"));
       WebElement redButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button[2]")));
        redButton.click();
    }

    public String deletelist() {
        //WebElement notification = driver.findElement(By.xpath("//p[@class='msg']"));
        WebElement notification =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='msg']")));
        return notification.getText();

    }



}
