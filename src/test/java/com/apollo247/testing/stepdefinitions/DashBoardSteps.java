package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardSteps {

	@When("User clicks on {string} module")
	public void user_clicks_on_module(String ModuleName) {
		Pages.dashboardPage.clickOnModule(ModuleName);

	}

	@Then("check user in on correct module")
	public void check_user_in_on_correct_module() {
		String title = Pages.dashboardPage.getCurrentPageUrl();
		System.out.println(title);
		assertTrue(title.contains("lab-tests"), "Page not Navigated to the module");
	}

	@When("User clicks on profile module")
	public void user_clicks_on_profile_module() {
		Pages.dashboardPage.clickOnMyAccountBtn();

	}

}