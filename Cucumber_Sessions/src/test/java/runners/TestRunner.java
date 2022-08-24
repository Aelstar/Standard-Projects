package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\ahmed.abdelstar\\eclipse-workspace\\Cucumber_Sessions\\src\\test\\java\\features\\Files", glue="Cucumber_Sessions\\src\\test\\java\\testCases", plugin="pretty", monochrome=true)

public class TestRunner {

}
