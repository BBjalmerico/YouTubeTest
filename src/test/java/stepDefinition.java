import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        initPage = new InitPage(driver);
    }

    @After
    public void shutDown(){
        videoPage.cleanup();
    }

    @Given("^I navigate to YouTube$")
    public void navigate() throws InterruptedException {
        initPage.navigateToInit();
    }

    @And("^I find my video after searching$")
    public void vidCheck() throws InterruptedException {
        searchPage = initPage.navigateToSearchPage("The Smashing Pumpkins 1979");
        videoPage = searchPage.parseVideo();
    }

    @When("^I mute the volume$")
    public void vidExitFull() throws InterruptedException {
        videoPage.setMute();
    }

    @And("^I disable autoplay$")
    public void vidStart() throws InterruptedException {
        videoPage.disableAutoplay();
    }

    @And("^I make my video fullscreen$")
    public void vidHD() throws InterruptedException {
        videoPage.setFullscreen();
    }

    @Then("^I skip through my video$")
    public void vidSkip(){
        videoPage.skipToEnd();
    }

    @And("^I wait until the video ends$")
    public void vidWait() throws InterruptedException {
        videoPage.waitToEnd();
    }

    @And("^Verify that it's over$")
    public void vidVerify(){
        videoPage.verifyEnded();
    }
}
