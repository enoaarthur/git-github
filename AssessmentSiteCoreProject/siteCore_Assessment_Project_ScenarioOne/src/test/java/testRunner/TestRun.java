package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * To be able to launch the scenario as a JUnit test, this class is needed
 * Notice That we can also launch our scenario from feature file as a cucum
 * ber feature.
 * Here we only need to set some options like where to find the features to run, attach the stepDefinitions
 * where the features steps are implemented
 * We use a plugin pretty to generate an html report  
 */


@RunWith(Cucumber.class)
@CucumberOptions
 		       (
 				features ="C:\\Users\\TEMP.DOMAIN01\\eclipse-workspace\\"
 						+ "siteCore_Assessment_Project_ScenarioOne"
 						+ "\\src\\test\\java\\Features",
 				glue="stepDefinitions",
 				dryRun=false,
 				monochrome=true,
 				plugin= {"pretty", "html:test-output"}
 				)
public class TestRun {

}
