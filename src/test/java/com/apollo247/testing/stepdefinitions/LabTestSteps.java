package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabTestSteps {

	@When("User searches for {string}")
	public void user_searches_for(String testName) {
		Pages.labTestPage.closePopup();
		Pages.labTestPage.searchTest(testName);
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String string) {
		boolean flag = Pages.labTestPage.isResultDisplayed();
		assertTrue(flag, "Results for the search are not displayed");
	}

}
