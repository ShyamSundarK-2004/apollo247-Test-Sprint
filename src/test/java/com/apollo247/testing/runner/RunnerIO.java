package com.apollo247.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/apollo247/testing/features/Prescription-scenario.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false, plugin = {
		"pretty", "html:Reports/Lab_Test-Report.html" })
public class RunnerIO extends AbstractTestNGCucumberTests {
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
}
