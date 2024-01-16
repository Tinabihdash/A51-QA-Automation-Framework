import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    //private String baseUrl = "https://qa.koel.app/";


    @Test
   public void addSongToPlaylist(){
        String expectedSongAddedMessage ="Added 1 song into \"Val.\"";
//steps
//launchBrowser();
//navigateLoginPage(baseUrl);
provideEmail("valentyna.bihdash@testpro.io");
providePassword("TestTest1!");
clickSubmit();
searchSongName("take my hand");
clickViewAll();
clickFirstSong();
clickAddButton();
choosePlaylist();



       // Assert.assertEquals(getAddToPlaylistSuccessMSG(),expectedSongAddedMessage);
    }

    public void searchSongName(String name){
       // WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
  WebElement searchField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        searchField.sendKeys(name);

    }

    public void clickViewAll(){
       // WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        WebElement viewAll =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='view-all-songs-btn']")));

        viewAll.click();


    }
   public void  clickFirstSong()  {
       //WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
      WebElement firstSong =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
       firstSong.click();

    }
    public void clickAddButton(){
        //WebElement addButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));

        WebElement addButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addButton.click();
    }


    public void choosePlaylist(){
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Val' )]"));
      WebElement playlist =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Val' )]")));
       playlist.click();

    }
    public String getAddToPlaylistSuccessMSG(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
