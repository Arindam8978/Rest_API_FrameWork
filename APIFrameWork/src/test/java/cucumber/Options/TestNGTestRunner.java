package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json", glue = { "stepDefinations" }/* ,tags="@DeletePlace" */ )
	public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
