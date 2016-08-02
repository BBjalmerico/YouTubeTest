import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class SearchPage extends AbstractPage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public VideoPage parseVideo(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/watch?v=4aeETEoNfOg']")));

        driver.findElement(By.xpath("//a[@href='/watch?v=4aeETEoNfOg']")).click();

        return new VideoPage(driver);
    }

}
