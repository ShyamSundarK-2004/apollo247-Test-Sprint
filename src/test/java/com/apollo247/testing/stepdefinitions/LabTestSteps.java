package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LabTestSteps {
	// ================= DashBoard Scenarios =================

	@Given("User is on Lab Tests page")
	public void user_is_on_lab_tests_page() {
		Pages.dashboardPage.clickOnModule("Lab Tests");
		Pages.labTestPage.closePopupIfPresent();
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

		default:
			throw new IllegalArgumentException("Invalid type: " + type);
		}
	}

	// ================= PRESCRIPTION FLOW =================

	@When("User clicks on book test using prescription")
	public void user_clicks_on_book_test_using_prescription() {
		Pages.labTestPage.closePopupIfPresent();

		Pages.labTestPage.clickOnBookByPrescriptionModule();
	}

	@When("User uploads valid prescription")
	public void user_uploads_valid_prescription() {

		String path = "C:\\Users\\Shyam Sundar\\Documents\\prescription2.jpeg";

		Pages.bookByPrescriptionPage.uploadFile(path);

		assertTrue(Pages.bookByPrescriptionPage.isFileAttached(), "Prescription file not uploaded successfully");

	}

	@Then("verify  proceed button is enabled")
	public void verify_proceed_button_is_enabled() {
		assertTrue(Pages.bookByPrescriptionPage.isProceedBtnEnabled(), "Proceed button is not enabled");
	}

	// ================= Radiology Scenarios =================

	@When("User clicks on lab test search bar")
	public void user_clicks_on_lab_test_search_bar() {
		Pages.labTestPage.closePopupIfPresent();
		Pages.labTestPage.clickOnSearchBox();
	}

	@When("User clicks on explore radiology option and switch to radiology tab")
	public void user_clicks_on_explore_radiology_option_and_switch_to_radiology_tab() {
		Pages.labTestPage.clickOnRadiologyBookingBtn();
	}

	@Then("User should be on radiology page")
	public void user_should_be_on_radiology_page() {
		String url = Pages.radiologyPage.getCurrentPageUrl();
		assertTrue(url.contains("radiology"), "Not Switched to Radiology page");
	}

	@When("User enters radiology details")
	public void user_enters_radiology_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> allData = dataTable.asMaps();

		for (Map<String, String> row : allData) {

			String city = row.get("city");
			String hospital = row.get("hospital");
			String testName = row.get("tests");
			String date = row.get("date");
			String filePath = row.get("filePath");

			Pages.radiologyPage.chooseCity(city);
			Pages.radiologyPage.chooseHospital(hospital);
			Pages.radiologyPage.chooseDate(date);
			Pages.radiologyPage.chooseTestName(testName);
			Pages.radiologyPage.UploadPrescription(filePath);

		}

	}

	@Then("User should see request call button is enabled")
	public void user_should_see_request_call_button_is_enabled() {
		assertTrue(Pages.radiologyPage.isRequestCallBtnEnabled(), "Request Call Button is not Enabled");
	}

	// ================= End To End Scenarios =================
}