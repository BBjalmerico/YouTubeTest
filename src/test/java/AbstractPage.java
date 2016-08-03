import org.openqa.selenium.WebDriver;

/**
 * Created by Jonathan on 8/1/2016.
 */
public class AbstractPage
{
    protected WebDriver driver;

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public InitPage navigateToInit()
    {
        driver.navigate().to("http://youtube.com");
        return new InitPage(driver);
    }

    public void cleanup()
    {
        driver.quit();
    }

    public void myWait(long time)
    {
        long startTime;
        long currentTime = startTime = System.currentTimeMillis();
        while (currentTime - startTime <= time)
        {
            currentTime = System.currentTimeMillis();
        }
    }

    class myPendingException extends Exception
    {
        public myPendingException(String msg){
            super(msg);
        }
    }
}
