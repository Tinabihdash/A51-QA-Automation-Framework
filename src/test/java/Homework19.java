import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {


    @Test

    public void deletePlaylist()  throws InterruptedException{
        String expectedPlaylistDeleteMessage = "Delete the playlist \"Val\"?";
        navigateLoginPage();
        provideEmail("valentyna.bihdash@testpro.io");
        providePassword("TestTest1!");
        clickSubmit();
        clickOnPlaylist();
        clickOnRedButton();
        Thread.sleep(2000);

        Assert.assertEquals(deletelist(),expectedPlaylistDeleteMessage);

    }

    public void clickOnPlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]"));
        playlist.click();
        Thread.sleep(2000);

    }

    public void clickOnRedButton() throws InterruptedException {
        WebElement redButton = driver.findElement(By.xpath("//*[@id='playlistWrapper']/header/div[3]/span/button[2]"));
        redButton.click();
        Thread.sleep(2000);
    }

    public String deletelist() {
        WebElement notification = driver.findElement(By.xpath("//p[@class='msg']"));
        return notification.getText();

    }



}
