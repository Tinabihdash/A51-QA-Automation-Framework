import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

   @Test
    public void playSong() {
      navigateLoginPage();
        provideEmail("valentyna.bihdash@testpro.io");
        providePassword("TestTest1!");
        clickSubmit();
        playNextSong();
        Assert.assertTrue(songIsPlaying());
    }

    public void  playNextSong (){
        WebElement playNext = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNext.click();
        playButton.click();


    }

    public boolean songIsPlaying() {
        //WebElement volume = driver.findElement(By.xpath("//*[@id='volumeRange']"));
        WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundbar.isDisplayed();

    }

}
