package com.apollo247.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

<<<<<<< HEAD
@CucumberOptions(features = "src/test/java/com/apollo247/testing/features/LabTest.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false)
=======

@CucumberOptions(features = "./src/test/java/com/apollo247/testing/features/TS_INS_01.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false)

>>>>>>> feature/insurance
public class RunnerIO extends AbstractTestNGCucumberTests {

}
