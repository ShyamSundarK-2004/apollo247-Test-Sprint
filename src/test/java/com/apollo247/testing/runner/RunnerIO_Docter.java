package com.apollo247.testing.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;


import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
	    features = {"./src/test/java/com/apollo247/testing/features/hearttool.feature"},
	    glue = "com.apollo247.testing.stepdefinitions",
	    dryRun=false)
//@CucumberOptions(features= {"./src/test/java/com/apollo247/testing/features/location.feature"},glue="com.apollo247.testing.stepdefinitions", dryRun = false)
//@CucumberOptions(features = {"./src/test/java/com/apollo247/testing/features/MyAppointment.feature"}, glue = "com.apollo247.testing.stepdefinitions", dryRun = false)
//@CucumberOptions(features = {"./src/test/java/com/apollo247/testing/features/FilterDocter.feature"}, glue = "com.apollo247.testing.stepdefinitions", dryRun = false)
//@CucumberOptions(features = "./src/test/java/com/apollo247/testing/features/FindDocter.feature", glue = "com.apollo247.testing.stepdefinitions", dryRun = false)
public class RunnerIO_Docter extends AbstractTestNGCucumberTests {

}
