import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class SearchPage extends AbstractPage
{
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }

    public VideoPage parseVideo(String query)
    {
        int retry = 0;
        int maxRetry = 6;

        while(retry < maxRetry){
            try {
                driver.findElement(By.xpath("//a[@href='/watch?v=" + query + "']")).click();
                break;
            } catch (NoSuchElementException e) {
                myWait(500);
                retry++;
            }
        }
        if(retry >= maxRetry){
            System.out.println("Timed out while parsing for video");
        }

        return new VideoPage(driver);
    }

}
