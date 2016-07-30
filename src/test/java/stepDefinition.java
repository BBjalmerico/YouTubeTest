import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Jonathan on 7/28/2016.
 */
public class stepDefinition {

    WebDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
    }

    @After
    public void cleanup(){
        driver.close();
    }

    @Given("^I navigate to YouTube$")
    public void navigate() throws InterruptedException {
        driver.get("http://Youtube.com");
        Thread.sleep(1000);
    }

    @Given("^I find my video after searching$")
    public void vidCheck() throws InterruptedException {
        driver.findElement(By.id("masthead-search-term")).sendKeys("Smashing pumpkins 1979");
        driver.findElement(By.id("search-btn")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@href='/watch?v=4aeETEoNfOg']")).click();
        Thread.sleep(9000);
    }

    @And("^I disable autoplay$")
    public void vidStart(){
        if (driver.findElement(By.id("autoplay-checkbox")).isEnabled()) {
            driver.findElement(By.id("autoplay-checkbox")).click();
        }
        else {
            System.out.println("Autoplay already disabled");
        }
//        driver.findElement(By.xpath("//button[@title='Mute']")).click();
    }

    @When("^I skip the ad$")
    public void vidPause() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title"));

        if(driver.findElement(By.xpath("//button[@class='videoAdUiSkipButton videoAdUiAction']")).isEnabled()){
            driver.findElement(By.xpath("//button[@class='videoAdUiSkipButton videoAdUiAction']")).click();
        }
    }

    @And("^I make my video fullscreen$")
    public void vidHD() throws InterruptedException {
        driver.findElement(By.xpath("//button[@title='Full screen']")).click();
        Thread.sleep(5000);
    }

    @Then("^I turn its quality up$")
    public void vidExitFull() throws InterruptedException {

    }

    @And("^Skip to the end$")
    public void vidSkip() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("document.getElementsByTagName(\"video\")[0].currentTime = 260;");
        Thread.sleep(5000);


    }

    @And("^Verify that it's over$")
    public void vidVerify(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Assert.assertTrue("Video has not ended", Boolean.valueOf(js.executeScript("return document.getElementsByTagName(\"video\")[0].ended;").toString()));

    }


}
