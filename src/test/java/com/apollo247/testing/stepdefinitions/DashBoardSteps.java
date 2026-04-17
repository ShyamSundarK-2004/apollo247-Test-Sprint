package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardSteps {

	@Given("User is on Lab Tests page")
	public void user_is_on_lab_tests_page() {
		Pages.dashboardPage.clickOnModule("Lab Tests");
	}

	@Then("check user in on correct module")
	public void check_user_in_on_correct_module() {
		String title = Pages.labTestPage.getCurrentPageUrl();
		assertTrue(title.contains("lab-tests"), "Page not Navigated to the module");
	}

	@When("User clicks on profile module")
	public void user_clicks_on_profile_module() {
		Pages.dashboardPage.clickOnMyAccountBtn();

	}

}