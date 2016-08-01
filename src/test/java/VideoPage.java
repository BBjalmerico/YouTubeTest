import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class VideoPage extends AbstractPage {

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage disableAutoplay(){
        if (driver.findElement(By.id("autoplay-checkbox")).isEnabled()) {
            driver.findElement(By.id("autoplay-checkbox")).click();
        }
        else {
            System.out.println("Autoplay already disabled");
        }

        return new VideoPage(driver);
    }

    public VideoPage setFullscreen(){
        driver.findElement(By.xpath("//button[@title='Full screen']")).click();

        return new VideoPage(driver);
    }

    public VideoPage skipTo(int time){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByTagName(\"video\")[0].currentTime =" + (time) +";");

        return new VideoPage(driver);
    }

    public VideoPage setVolume(float volume){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByTagName(\"video\")[0].volume =" + (volume) +";");

        return new VideoPage(driver);
    }

    public VideoPage verifyEnded(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Assert.assertTrue("Video not ended", Boolean.valueOf(js.executeScript("return document.getElementsByTagName(\"video\")[0].ended;").toString()));
        return new VideoPage(driver);
    }
}
