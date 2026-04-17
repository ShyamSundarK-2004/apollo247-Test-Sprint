package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS_INS_01 {
	@Given("User navigates to Health Insurance page and enter pincode {string}")
	public void user_navigates_to_health_insurance_page_and_enter_pincode(String pincode) {
		Pages.dashboardPage.clickonHealthInsuranceModule();
		Pages.healthInsurancePage.performEnterPinCode(pincode);
		System.out.println("navigated successfully ");

	}
	@When("User selects {string} and {string} as members")
	public void user_selects_and_as_members(String gender, String member) {
	    Pages.healthInsurancePage.selectGender(gender);
	    Pages.healthInsurancePage.selectMember(member);
	    System.out.println("user selected");
	}
	@When("User clicks on {string}")
	public void user_clicks_on(String viewPlans) {
	    Pages.healthInsurancePage.clickViewButton(viewPlans);
	    System.out.println("viewed the plans");
	}
	@Then("Insurance plans should be loaded successfully")
	public void insurance_plans_should_be_loaded_successfully() {
		Assert.assertTrue(Pages.healthInsurancePage.viewPlanHeader().isDisplayed(), "View Plans header not displayed");
		Assert.assertTrue(Pages.healthInsurancePage.viewNumberOfPlans().size() > 0, "No plans found on page");
	   
	}


}
