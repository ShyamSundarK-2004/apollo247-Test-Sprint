package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabTestSteps {

	// ================= SEARCH Scenarios =================

	@When("User searches for {string}")
	public void user_searches_for(String testName) {
		Pages.labTestPage.closePopupIfPresent();
		Pages.labTestPage.searchTest(testName);
	}

	@Then("validate search result for {string}")
	public void validate_search_result_for(String type) {

		switch (type.toLowerCase()) {

		case "valid":
			assertTrue(Pages.labTestPage.isResultDisplayed(), "Cards are not displayed for valid search");
			break;

		case "invalid":
			assertTrue(Pages.labTestPage.isErrorMessageDisplayed(), "Error message not displayed for invalid input");
			break;

		case "empty":
			assertTrue(Pages.labTestPage.isNoActionPerformed(), "Unexpected behavior for empty search");
			break;

		default:
			throw new IllegalArgumentException("Invalid type: " + type);
		}
	}

}