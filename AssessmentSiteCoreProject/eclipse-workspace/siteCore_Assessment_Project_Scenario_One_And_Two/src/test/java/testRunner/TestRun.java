package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
 		       (
 				features ="C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\"
 						+ "siteCore_Assessment_Project_Scenario_One_And_Two"
 						+ "\\src\\test\\java\\Features",
 				glue="stepDefinitions",
 				dryRun=false,
 				monochrome=true,
 				plugin= {"pretty", "html:test-output"}
 				)
public class TestRun {

}
