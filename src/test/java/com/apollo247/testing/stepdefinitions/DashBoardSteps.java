package com.apollo247.testing.stepdefinitions;

import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashBoardSteps {

	private BaseClass b;

	public DashBoardSteps(BaseClass b) {
		this.b = b;
	}

	@When("close the popup shown")
	public void close_the_popup_shown() {
		Pages.dashboardPage.closeDomPopup();
	}

	@When("User logs in with mobile number {string}")
	public void user_logs_in_with_mobile_number(String mobileNumber) {
		Pages.dashboardPage.login(mobileNumber);
	}

	@Then("User should be prompted for OTP verification")
	public void user_should_be_prompted_for_otp_verification() {
		Pages.dashboardPage.enterOtpAndclickVerify();
	}

	@When("User clicks on {string} module")
	public void user_clicks_on_module(String ModuleName) {
		Pages.dashboardPage.clickonModule(b.driver, ModuleName);
	}

}
