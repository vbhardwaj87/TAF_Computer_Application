package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        tags = {"@regression, @GUI"},
        //For running the regression only scenarios uncomment the below tags and comment the original
//        tags = {"@regression},
        features = "src/test/resources/features/"
        ,glue={"Steps"}
)
public class TestRun{
}