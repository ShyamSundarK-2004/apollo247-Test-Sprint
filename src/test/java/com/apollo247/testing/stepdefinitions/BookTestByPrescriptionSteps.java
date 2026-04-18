package com.apollo247.testing.stepdefinitions;

import static org.testng.Assert.assertTrue;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookTestByPrescriptionSteps {

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

//		Pages.bookByPrescriptionPage.clickOnProceedBtn();
	}

	@Then("verify prescription test is successfully created")
	public void verify_prescription_test_is_successfully_created() {
//		assertTrue(Pages.bookByPrescriptionPage.checkTestStatus(), "Test Not Booked By using Prescription");
	}
}
