import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class VideoPage extends AbstractPage
{

    public VideoPage(WebDriver driver)
    {
        super(driver);
    }

    public VideoPage disableAutoplay()
    {
        int retry = 0;
        int maxRetry = 6;

        while(retry < maxRetry) {
            try {
                driver.findElement(By.id("autoplay-checkbox")).click();
                retry = 0;
                break;
            }catch (NoSuchElementException e){
                myWait(500);
                retry++;
            }
        }
        if (retry >= maxRetry){
            System.out.println("Timed out while disabling Autoplay");
        }

        return new VideoPage(driver);
    }

    public VideoPage setFullscreen()
    {
        int retry = 0;
        int maxRetry = 6;

        while (retry < maxRetry) {
            try {
                driver.findElement(By.xpath("//button[@title='Full screen']")).click();
                retry = 0;
                break;
            }catch (NoSuchElementException e){
                myWait(500);
                retry++;
            }
        }

        return new VideoPage(driver);
    }

    public VideoPage skipToEnd()
    {
        (new Actions(driver))
                .dragAndDrop(driver.findElement(By.className("ytp-progress-list")),
                driver.findElement(By.xpath("//button[@title='Full screen' or @title='Exit full screen']"))).perform();

        return new VideoPage(driver);
    }

    public VideoPage setMute()
    {
        int retry = 0;
        int maxRetry = 6;

        while (retry < maxRetry) {
            try {
                driver.findElement(By.xpath("//button[@title='Mute']")).click();
                retry = 0;
                break;
            }catch (ElementNotVisibleException e){
                myWait(500);
                retry++;
            }
        }
        if (retry >= maxRetry){
            System.out.println("Timed out while muting volume");
        }

        return new VideoPage(driver);
    }

    public VideoPage verifyEnded()
    {
        boolean pending = true;
        int retry = 0;
        int timeOut = 30;

        while(pending && retry < timeOut) {
            try {
                if (driver.findElement(By.className("ytp-endscreen-content")).isDisplayed() ||
                        //In case autoplay was not disabled properly
                        driver.findElement(By.className("ytp-upnext-autoplay-icon")).isDisplayed())
                {
                    pending = false;
                    retry = 0;
                    break;
                }
                else{
                    throw new myPendingException("Video not yet finished");
                }
            } catch (myPendingException e)
            {
                retry++;
                myWait(1000);
            }
        }
        //Signal test failure if timeOut reached
        if (retry >= timeOut){
            Assert.fail("Video failed to finish during allotted time.");
        }

        return new VideoPage(driver);
    }
}
