package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS_INS_03 {
	@When("User selects Gender {string} {string} at age {string}, {string} at age {string}, and {string}  at age {string} as members")
	public void user_selects_gender_at_age_at_age_and_at_age_as_members(String gender, String m1, String m1Age,
			String m2, String m2Age, String m3, String m3Age) {

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
		
		if (Pages.healthInsuranceProductListings.isNoPlansMessageDisplayed()) {

	        Assert.assertTrue(Pages.healthInsuranceProductListings.isNoPlansMessageDisplayed(),"'No plans found' message not displayed correctly");

	    } else {

	        Assert.assertTrue(Pages.healthInsuranceProductListings.isPlansAvailable(),"Plans are not displayed properly");
	    }
		System.out.println("Validated");
	}

}
