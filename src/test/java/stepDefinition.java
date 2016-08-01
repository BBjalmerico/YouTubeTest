import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Jonathan on 7/28/2016.
 */
public class stepDefinition {

    WebDriver driver = new FirefoxDriver();
    InitPage initPage;
    SearchPage searchPage;
    VideoPage videoPage;

    @Before
    public void setup(){
    }

    @After
    public void close(){

    }

    @Given("^I navigate to YouTube$")
    public void navigate() throws InterruptedException {
        InitPage initPage = new InitPage(driver);
        initPage.navigateToInit();
    }

    @Given("^I find my video after searching$")
    public void vidCheck() throws InterruptedException {

        searchPage = initPage.navigateToSearchPage("The Smashing Pumpkins 1979");

        Thread.sleep(9000);
    }

    @And("^I disable autoplay$")
    public void vidStart() throws InterruptedException {
        videoPage.disableAutoplay();

//        if (driver.findElement(By.id("autoplay-checkbox")).isEnabled()) {
//            driver.findElement(By.id("autoplay-checkbox")).click();
//        }
//        else {
//            System.out.println("Autoplay already disabled");
//        }
        Thread.sleep(15000);
//        driver.findElement(By.xpath("//button[@title='Mute']")).click();
    }

    @When("^I skip the ad$")
    public void vidPause() throws InterruptedException {

    }

    @And("^I make my video fullscreen$")
    public void vidHD() throws InterruptedException {
//        driver.findElement(By.xpath("//button[@title='Full screen']")).click();
        videoPage.setFullscreen();
    }

    @Then("^I mute the volume$")
    public void vidExitFull() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementsByTagName(\"video\")[0].volume = 0.5;");
        videoPage.setVolume(0.5f);

        Thread.sleep(3000);
    }

    @And("^Skip to the end$")
    public void vidSkip() throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementsByTagName(\"video\")[0].currentTime = 260;");
        videoPage.skipTo(260);

        Thread.sleep(5000);
    }

    @And("^Verify that it's over$")
    public void vidVerify(){
        videoPage.verifyEnded();
    }


}
