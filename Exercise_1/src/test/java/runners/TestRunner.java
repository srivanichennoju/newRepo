package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		glue = { "stepDefinitions" }, 
		monochrome = true, 
		dryRun = false , 
				plugin = {"html:target/cucumber-reports/CucumberhmtlReport",
						"json:target/cucumber-reports/Cucumber.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {

}
