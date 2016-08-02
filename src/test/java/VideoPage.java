import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class VideoPage extends AbstractPage {

    public VideoPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage disableAutoplay(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains("/watch?v=4aeETEoNfOg"));

        driver.findElement(By.id("autoplay-checkbox")).click();

        return new VideoPage(driver);
    }

    public VideoPage setFullscreen(){
        driver.findElement(By.xpath("//button[@title='Full screen']")).click();

        return new VideoPage(driver);
    }

    public VideoPage skipToEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByTagName(\"video\")[0].currentTime = 261;");

//        (new Actions(driver)).dragAndDropBy(driver.findElement(By.className("ytp-scrubber-button")),
//                600,0);

        return new VideoPage(driver);
    }

    public VideoPage waitToEnd(){
        WebDriverWait wait = new WebDriverWait(driver,300);
        wait.until(ExpectedConditions.textToBePresentInElement(By.className("ytp-time-current"),
                driver.findElement(By.className("ytp-time-duration")).getText()));

        return new VideoPage(driver);
    }

    public VideoPage setMute(){
        driver.findElement(By.xpath("//button[@title='Mute']")).click();

        return new VideoPage(driver);
    }

    public VideoPage verifyEnded(){
        Assert.assertFalse("Ending card not displayed",
                Boolean.valueOf(ExpectedConditions.invisibilityOfElementLocated(By.className("ytp-endscreen-content")).toString()));

        return new VideoPage(driver);
    }
}
