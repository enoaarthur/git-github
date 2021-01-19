package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
 		       (
 				features = "C:\\Users\\\\TEMP.DOMAIN01\\eclipse-workspace\\"
 						+ "siteCoreProject_Assessment_Scenario2\\src\\test\\java\\Features",
 				glue="stepDefinitions",
 				dryRun=false,
 				monochrome=true,
 				plugin= {"pretty", "html:test-output"}
 				)
public class TestRun {

}
