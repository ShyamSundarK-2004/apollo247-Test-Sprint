package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurance_Stepdefinition {

	@Given("User navigates to Health Insurance page and enter pincode {string}")
	public void user_navigates_to_health_insurance_page_and_enter_pincode(String pincode) {
		Pages.dashboardPage.clickonHealthInsuranceModule();
		Pages.healthInsurancePage.performEnterPinCode(pincode);
		System.out.println("navigated successfully ");

	}
	@When("User selects {string} and {string} at the age {string} as members")
	public void user_selects_and_at_the_age_as_members(String gender, String member, String age) {
		Pages.healthInsurancePage.selectGender(gender);
		Pages.healthInsurancePage.unselectMember();
		Pages.healthInsurancePage.selectMember(member, age);
		System.out.println("user selected");
	    
	}

	@When("User clicks on {string}")
	public void user_clicks_on(String viewPlans) {
		Pages.healthInsurancePage.clickViewButton(viewPlans);
		System.out.println("viewed the plans");

	}

	@Then("Insurance plans should be loaded successfully")
	public void insurance_plans_should_be_loaded_successfully() {
		Assert.assertTrue(Pages.healthInsuranceProductListings.viewPlanHeader().isDisplayed(), "View Plans header not displayed");
		Assert.assertTrue(Pages.healthInsuranceProductListings.viewNumberOfPlans().size() > 0, "No plans found on page");
		System.out.println("Plans are shown");
	}
	

	@When("User clicks on {string} without selecting any member")
	public void user_clicks_on_without_selecting_any_member(String viewPlans) {
		Pages.healthInsurancePage.unselectMember();
	    Pages.healthInsurancePage.clickViewButton(viewPlans);
	    System.out.println("Clicked view Plans");
	}
	@Then("Proper validation error message {string} should be displayed")
	public void proper_validation_error_message_should_be_displayed(String expectedMessage) {
	    String actualMessage =Pages.healthInsurancePage.errorMessageNoMemeberSelected();
	    Assert.assertEquals(actualMessage, expectedMessage, "Validation message mismatch");
	    System.out.println("Validated successfully");
	}
	
	@When("User selects Gender {string} {string} at age {string}, {string} at age {string}, and {string}  at age {string} as members")
	public void user_selects_gender_at_age_at_age_and_at_age_as_members(String gender, String m1, String m1Age,String m2, String m2Age, String m3, String m3Age) {
		Pages.healthInsurancePage.selectGender(gender);
		Pages.healthInsurancePage.unselectMember();
		Pages.healthInsurancePage.selectMember(m1, m1Age);
		Pages.healthInsurancePage.selectMember(m2, m2Age);
		Pages.healthInsurancePage.selectMember(m3, m3Age);
	}
	// Implemented user clicks on "View Plans" in another stepdefinition file
	// so clicked "View plans" button

	@Then("Family insurance plans should be displayed correctly")
	public void family_insurance_plans_should_be_displayed_correctly() {
		Assert.assertTrue(Pages.healthInsuranceProductListings.isNoPlansMessageDisplayed(),"'No plans found' message not displayed correctly");
        Assert.assertTrue(Pages.healthInsuranceProductListings.isPlansAvailable(),"Plans are not displayed properly");
		System.out.println("Validated");
	}
	
	// Existing Methods
		// User Selected "Male" and "Self" at the age "22"
		//User Clicked on "View plans" 
		
		
	@When("User applies coverage filter between {string}")
	public void user_applies_coverage_filter_between(String amount) {
	    Pages.healthInsuranceProductListings.coverageAmount(amount);
	    System.out.println("Coverage amount applied");
	}
	@When("User selects room rent type as {string}")
	public void user_selects_room_rent_type_as(String roomRentType) {
		Pages.healthInsuranceProductListings.roomRentType(roomRentType);
		System.out.println("Room Rent applied");
	    
	}
	@When("User sorts plans by {string}")
	public void user_sorts_plans_by(String plan) {
		Pages.healthInsuranceProductListings.sortByPlans(plan);
		System.out.println("Sorted by plans");
	    
	}
	//@Then("Plans should be displayed based on applied filters")
	//public void plans_should_be_displayed_based_on_applied_filters() {
	//	
//	    System.out.println("x");
	//}
		
		@Then("Plans should be displayed based on applied filters are {string}")
		public void plans_should_be_displayed_based_on_applied_filters_are(String coverageAmount) {
			
			Assert.assertTrue(Pages.healthInsuranceProductListings.isMatch(coverageAmount),"Price not matching filter");
			System.out.println("filter validated");
		    
		}


}
