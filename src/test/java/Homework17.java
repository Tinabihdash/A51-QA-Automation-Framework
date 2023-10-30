import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {


    @Test
   public void addSongToPlaylist() throws InterruptedException{
        String expectedSongAddedMessage ="Added 1 song into \"Val.\"";
//steps
launchBrowser();
navigateLoginPage();
provideEmail("valentyna.bihdash@testpro.io");
providePassword("TestTest1!");
clickSubmit();
searchSongName("take my hand");
clickViewAll();
clickFirstSong();
clickAddButton();
choosePlaylist();

Thread.sleep(2000);

        Assert.assertEquals(getAddToPlaylistSuccessMSG(),expectedSongAddedMessage);
    }

    public void searchSongName(String name) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAll() throws InterruptedException{
        WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);

    }
   public void  clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
       firstSong.click();
       Thread.sleep(2000);
    }
    public void clickAddButton() throws InterruptedException{
        WebElement addButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
    addButton.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException{
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Val' )]"));
       playlist.click();
        Thread.sleep(2000);
    }
    public String getAddToPlaylistSuccessMSG(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
