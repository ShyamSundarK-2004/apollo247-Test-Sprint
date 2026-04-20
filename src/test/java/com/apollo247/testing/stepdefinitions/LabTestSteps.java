package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD

import com.apollo247.testing.utilities.Pages;

=======

import com.apollo247.testing.utilities.BaseClass;

>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
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

	BaseClass b;

	public LabTestSteps(BaseClass b) {
		this.b = b;
	}

	// ================= DashBoard Scenarios =================

	@Given("User is on Lab Tests page")
	public void user_is_on_lab_tests_page() {
		b.getPages().dashboardPage.clickOnModule("Lab Tests");
		b.getPages().labTestPage.closePopupIfPresent();
	}

	@Then("check user in on correct module")
	public void check_user_in_on_correct_module() {
		String title = b.getPages().labTestPage.getCurrentPageUrl();
		assertTrue(title.contains("lab-tests"), "Page not Navigated to the module");
	}

	@When("User clicks on profile module")
	public void user_clicks_on_profile_module() {
		b.getPages().dashboardPage.clickOnMyAccountBtn();

	}

	// ================= SEARCH Scenarios =================

	@When("User searches for {string}")
	public void user_searches_for(String testName) {
<<<<<<< HEAD
		Pages.labTestPage.closePopupIfPresent();
		Pages.labTestPage.searchTest(testName);
=======
		b.getPages().labTestPage.closePopupIfPresent();
		b.getPages().labTestPage.searchTest(testName);
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9

	}

	@Then("validate search result for {string}")
	public void validate_search_result_for(String type) {

		switch (type.toLowerCase()) {

		case "valid":
			assertTrue(b.getPages().labTestPage.isResultDisplayed(), "Cards are not displayed for valid search");
			break;

		case "invalid":
<<<<<<< HEAD
			assertTrue(Pages.labTestPage.isErrorMessageDisplayed(), "Error message not displayed for invalid input");
=======
			assertTrue(b.getPages().labTestPage.isErrorMessageDisplayed(),
					"Error message not displayed for invalid input");
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
			break;

		default:
			throw new IllegalArgumentException("Invalid type: " + type);
		}
	}

	// ================= PRESCRIPTION FLOW =================

	@When("User clicks on book test using prescription")
	public void user_clicks_on_book_test_using_prescription() {
<<<<<<< HEAD
		Pages.labTestPage.closePopupIfPresent();

		Pages.labTestPage.clickOnBookByPrescriptionModule();
=======
		b.getPages().labTestPage.closePopupIfPresent();

		b.getPages().labTestPage.clickOnBookByPrescriptionModule();
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	}

	@When("User uploads valid prescription")
	public void user_uploads_valid_prescription() {

		String path = "C:\\Users\\Shyam Sundar\\Documents\\prescription2.jpeg";

<<<<<<< HEAD
		Pages.bookByPrescriptionPage.uploadFile(path);

		assertTrue(Pages.bookByPrescriptionPage.isFileAttached(), "Prescription file not uploaded successfully");
=======
		b.getPages().bookByPrescriptionPage.uploadFile(path);

		assertTrue(b.getPages().bookByPrescriptionPage.isFileAttached(), "Prescription file not uploaded successfully");
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9

	}

	@Then("verify  proceed button is enabled")
	public void verify_proceed_button_is_enabled() {
<<<<<<< HEAD
		assertTrue(Pages.bookByPrescriptionPage.isProceedBtnEnabled(), "Proceed button is not enabled");
=======
		assertTrue(b.getPages().bookByPrescriptionPage.isProceedBtnEnabled(), "Proceed button is not enabled");
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	}

	// ================= Radiology Scenarios =================

	@When("User clicks on lab test search bar")
	public void user_clicks_on_lab_test_search_bar() {
<<<<<<< HEAD
		Pages.labTestPage.closePopupIfPresent();
		Pages.labTestPage.clickOnSearchBox();
=======
		b.getPages().labTestPage.closePopupIfPresent();
		b.getPages().labTestPage.clickOnSearchBox();
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	}

	@When("User clicks on explore radiology option and switch to radiology tab")
	public void user_clicks_on_explore_radiology_option_and_switch_to_radiology_tab() {
<<<<<<< HEAD
		Pages.labTestPage.clickOnRadiologyBookingBtn();
=======
		b.getPages().labTestPage.clickOnRadiologyBookingBtn();
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	}

	@Then("User should be on radiology page")
	public void user_should_be_on_radiology_page() {
<<<<<<< HEAD
		String url = Pages.radiologyPage.getCurrentPageUrl();
=======
		String url = b.getPages().radiologyPage.getCurrentPageUrl();
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
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

<<<<<<< HEAD
			Pages.radiologyPage.chooseCity(city);
			Pages.radiologyPage.chooseHospital(hospital);
			Pages.radiologyPage.chooseDate(date);
			Pages.radiologyPage.chooseTestName(testName);
			Pages.radiologyPage.UploadPrescription(filePath);
			
=======
			b.getPages().radiologyPage.chooseCity(city);
			b.getPages().radiologyPage.chooseHospital(hospital);
			b.getPages().radiologyPage.chooseDate(date);
			b.getPages().radiologyPage.chooseTestName(testName);
			b.getPages().radiologyPage.UploadPrescription(filePath);
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9

		}

	}

	@Then("User should see request call button is enabled")
	public void user_should_see_request_call_button_is_enabled() {
<<<<<<< HEAD
		assertTrue(Pages.radiologyPage.isRequestCallBtnEnabled(), "Request Call Button is not Enabled");
=======
		assertTrue(b.getPages().radiologyPage.isRequestCallBtnEnabled(), "Request Call Button is not Enabled");
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	}

	// ================= End To End Scenarios =================
}