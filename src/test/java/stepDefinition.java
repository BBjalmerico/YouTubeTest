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
public class stepDefinition
{
    WebDriver driver = new FirefoxDriver();
    InitPage initPage;
    SearchPage searchPage;
    VideoPage videoPage;

    @Before
    public void setup()
    {
        initPage = new InitPage(driver);
    }

    @After
    public void shutDown()
    {
        videoPage.cleanup();
    }

    @Given("^I navigate to YouTube$")
    public void navigate()
    {
        initPage.navigateToInit();
    }

    @And("^I search for \"([^\"]*)\"$")
    public void vidCheck(String query)
    {
        searchPage = initPage.navigateToSearchPage(query);
    }

    @And("^I find the video with tag \"([^\"]*)\"$")
    public void findSpecific(String query){
        videoPage = searchPage.parseVideo(query);
    }

    @When("^I mute the volume$")
    public void vidExitFull()
    {
        videoPage.setMute();
    }

    @And("^I disable autoplay$")
    public void vidStart()
    {
        videoPage.disableAutoplay();
    }

    @And("^I make my video fullscreen$")
    public void vidHD()
    {
        videoPage.setFullscreen();
    }

    @Then("^I skip through my video$")
    public void vidSkip()
    {
        videoPage.skipToEnd();
    }

    @And("^Verify that it's over$")
    public void vidVerify()
    {
        videoPage.verifyEnded();
    }
}
