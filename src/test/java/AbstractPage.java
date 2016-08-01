import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public InitPage navigateToInit(){
        driver.navigate().to("http://youtube.com");
        return new InitPage(driver);
    }

    public void cleanup(){
        driver.quit();
    }
}
