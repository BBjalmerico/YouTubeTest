import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class SearchPage extends AbstractPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage parseVideo(){
        driver.findElement(By.xpath("//a[@href='/watch?v=4aeETEoNfOg']")).click();

        return new VideoPage(driver);
    }

}
