package testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\RestAssured3\\src\\test\\java\\featuresFiles", glue="RestAssured3\\src\\test\\java\\testCases", plugin= {"pretty", "html:target\\reports.html", "json:target\\reports.json"},tags= "@tag1", dryRun=true)

public class Runner {

}
