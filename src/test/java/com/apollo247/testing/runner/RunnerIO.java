package com.apollo247.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "./src/test/java/com/apollo247/testing/features/TS_INS_01.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false)

public class RunnerIO extends AbstractTestNGCucumberTests {

}
