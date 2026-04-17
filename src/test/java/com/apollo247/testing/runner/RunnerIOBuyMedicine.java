package com.apollo247.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	        features = {"src/test/java/com/apollo247/testing/features/BuyMedicine.feature"},
	        glue = "com.apollo247.testing.stepdefinitions",
	        dryRun = true)
	public class RunnerIOBuyMedicine extends AbstractTestNGCucumberTests {
	}

