import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import sun.security.util.PendingException;

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
        int timeOut = 6;

        while(retry < timeOut) {
            try {
                driver.findElement(By.id("autoplay-checkbox")).click();
                retry = 0;
                break;
            }catch (NoSuchElementException e){
                myWait(500);
                retry++;
            }
        }
        if (retry >= timeOut){
            Assert.fail("Timed out while disabling Autoplay");
        }

        return new VideoPage(driver);
    }

    public VideoPage setFullscreen()
    {
        int retry = 0;
        int timeOut = 6;

        while (retry < timeOut) {
            try {
                driver.findElement(By.xpath("//button[@title='Full screen']")).click();
                retry = 0;
                break;
            }catch (NoSuchElementException e){
                myWait(500);
                retry++;
            }
        }
        if(retry >= timeOut)
        {
            Assert.fail("Timed out attempting to make video fullscreen");
        }

        return new VideoPage(driver);
    }

    public VideoPage skipToEnd()
    {
        int retry = 0;
        int timeOut = 6;

        while (retry < timeOut) {
            try{
                (new Actions(driver))
                        .dragAndDrop(driver.findElement(By.className("ytp-progress-list")),
                                driver.findElement(By.xpath("//button[@title='Full screen' or @title='Exit full screen']"))).perform();
                retry = 0;
                break;
            }catch (NoSuchElementException e){
                myWait(500);
                retry++;
            }
        }
        if(retry >= timeOut)
        {
            Assert.fail("Timed out while trying to advance video");
        }

        return new VideoPage(driver);
    }

    public VideoPage setMute()
    {
        int retry = 0;
        int timeOut = 6;

        while (retry < timeOut) {
            try {
                driver.findElement(By.xpath("//button[@title='Mute']")).click();
                retry = 0;
                break;
            }catch (ElementNotVisibleException e){
                myWait(500);
                retry++;
            }
        }
        if (retry >= timeOut){
            Assert.fail("Timed out while muting volume");
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
                        //In case autoplay was not disabled
                        driver.findElement(By.className("ytp-upnext-autoplay-icon")).isDisplayed())
                {
                    pending = false;
                    retry = 0;
                    break;
                }
                else{
                    throw new PendingException();
                }
            } catch (PendingException e)
            {
                retry++;
                myWait(1000);
            } catch (NoSuchElementException e)
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

    public VideoPage waitForAd()
    {
        int retry = 0;
        int timeOut = 15;
        boolean isSkippable = true;

        while(retry < timeOut){
            try {
                if(driver.findElement(By.className("videoAdUiAuthorIconImage")).isDisplayed()){
                    try {
                        if (isSkippable){
                            driver.findElement(By.linkText("Skip Ad")).click();

                            retry = 0;
                            break;
                        }

                    } catch (NoSuchElementException e){
                        isSkippable = false;
                    }
                }
                else {
                    throw new PendingException();
                }
            }catch (NoSuchElementException e){
                System.out.println("Cannot see Ad");

                retry++;
                myWait(1000);
            }catch (PendingException e){
                System.out.print("Pending exception caught");

                retry++;
                myWait(1000);
            }
        }
        if (retry >= timeOut){
            Assert.fail("Ad did not finish in allotted time");
        }

        return new VideoPage(driver);
    }
}
