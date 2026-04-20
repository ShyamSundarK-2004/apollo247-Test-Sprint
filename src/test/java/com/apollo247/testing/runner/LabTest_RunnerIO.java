package com.apollo247.testing.runner;

<<<<<<< HEAD
=======
import org.testng.annotations.DataProvider;

>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/apollo247/testing/features/LabTest.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false, plugin = {
<<<<<<< HEAD
		"pretty", "html:Reports/Lab_Test-Report.html" }, tags = "@radiologyScenario")
public class LabTest_RunnerIO extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
=======
		"pretty", "html:Reports/Lab_Test-Report.html" }, tags = "@labTest")
public class LabTest_RunnerIO extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
}
