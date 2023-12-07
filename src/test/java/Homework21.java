import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlayListName = "New playlist";

    @Test
public void renamePlaylist(){
       String  UpdatePlaylistMsg = "Updated playlist\"New playlist.\"";
     //login
        provideEmail("valentyna.bihdash@testpro.io");
        providePassword("TestTest1!");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),UpdatePlaylistMsg);
     //doubleClick
     //Enter new name
     //Assert

    }

    public void doubleClickPlaylist(){
        WebElement playlistElement  =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement inputPlaylistName =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        inputPlaylistName.sendKeys(Keys.chord(Keys.CONTROL, "A",Keys.BACK_SPACE));
        inputPlaylistName.sendKeys(newPlayListName);
        inputPlaylistName.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))));
        return notification.getText();
    }
}
