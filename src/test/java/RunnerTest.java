import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Jonathan on 7/28/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"},
        features = {"src/test/resources"}
)

public class RunnerTest
{

}
