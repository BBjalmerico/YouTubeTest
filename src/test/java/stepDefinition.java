import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    @Given("^I navigate to my YouTube video$")
    public void navigate(){
        driver.get("http://Youtube.com/watch?v=4aeETEoNfOg");
    }

    @Given("I verify that I am on my videos page")
    public void vidCheck() throws InterruptedException {
        Assert.assertTrue("Error: On incorrect page", driver.getCurrentUrl().equals("https://www.youtube.com/watch?v=4aeETEoNfOg"));
        Thread.sleep(5000);
    }

    @And("^I disable autoplay$")
    public void vidStart(){
        if (driver.findElement(By.id("autoplay-checkbox")).isEnabled()) {
            driver.findElement(By.id("autoplay-checkbox")).click();
        }
        else {
            System.out.println("Autoplay already disabled");
        }
    }

    @When("^I pause my video")
    public void vidEnterFull() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"movie_player\").play()");
    }

    @And("^I increase the resolution$")
    public void vidHD(){

    }

    @Then("^I close fullscreen$")
    public void vidExitFull(){

    }

    @And("^Skip to the end$")
    public void vidSkip(){

    }

    @And("^Verify that it's over$")
    public void vidVerify(){

    }


}
