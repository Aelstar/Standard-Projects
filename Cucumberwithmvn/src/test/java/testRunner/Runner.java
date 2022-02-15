package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumberwithmvn\\src\\test\\java\\features",glue="Cucumberwithmvn\\src\\test\\java\\testCases",tags="@outline", plugin= {"pretty", "html:target\\reports.html", "json:target\\reports.json"},dryRun=false)
public class Runner {

}
