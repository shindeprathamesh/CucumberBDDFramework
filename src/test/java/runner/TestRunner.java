package runner;


import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import testbase.TestBase;

@RunWith(Cucumber.class)
@CucumberOptions(
		 
		 	features = {"src/test/resources/features"},
		 	glue = {"stepdefinitions","hooks"},
		 	plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		 	monochrome = true

		)

public class TestRunner extends TestBase {
	
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(config.getExtentConfigPath()); }
	 */

}
