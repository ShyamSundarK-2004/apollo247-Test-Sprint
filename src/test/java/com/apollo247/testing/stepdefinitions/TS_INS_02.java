package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TS_INS_02 {
	
	
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

}
