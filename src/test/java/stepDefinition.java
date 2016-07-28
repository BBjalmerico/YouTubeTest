import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
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
//        driver.close();
    }

    @Given("^I navigate to YouTube$")
    public void navigate(){
        driver.navigate().to("http://Youtube.com");
    }

    @Given("^I search for my video$")
    public void vidSearch(){
        driver.findElement(By.name("search_query")).sendKeys("1979");
        driver.findElement(By.id("search-btn")).click();
    }

    @And("^I locate my video$")
    public void vidSelect(){
        driver.findElement(By.xpath("//a[@href='/watch?v=4aeETEoNfOg']")).click();
    }

    @When("^I start my video$")
    public void vidStart(){

    }

    @And("^I make it fullscreen$")
    public void vidEnlarge(){

    }

    @Then("^I skip to the end$")
    public void vidSkip(){

    }

    @And("^Verify that it's over$")
    public void vidVerify(){

    }


}
