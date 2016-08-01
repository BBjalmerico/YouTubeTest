import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class InitPage extends AbstractPage {

    public InitPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage navigateToSearchPage (String query){
        driver.findElement(By.id("masthead-search-term")).sendKeys(query);
        driver.findElement(By.id("search-btn")).click();

        return new SearchPage(driver);
    }
}
