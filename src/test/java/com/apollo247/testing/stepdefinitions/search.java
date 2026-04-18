package com.apollo247.testing.stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search extends BaseClass {
	private BaseClass b;

	public search(BaseClass b) {
		this.b = b;
	}

	@Given("Open the Browser")
	public void open_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("user launches the Apollo247 {string}")
	public void user_launches_the_apollo247(String URL) {
		driver.get(URL);
		Pages.loadAllPages(driver);
	}

	@Given("user closes the popup")
	public void user_closes_the_popup() {
		Pages.dashboardPage.closeDomPopup();
	}

	@When("user logs in with mobile number {string}")
	public void user_logs_in_with_mobile_number(String mobile) {
		Pages.dashboardPage.login(mobile);
		Pages.dashboardPage.enterOtpAndclickVerify();
	}

	@When("user clicks on Find Doctors")
	public void user_clicks_on_find_doctors() {
		Pages.dashboardPage.clickOnModule("Find Doctors");
	}

	@When("user searches for {string} specialist in {string} on date {string}")
	public void searchDoctor(String spec, String city, String date) {

		Pages.Searchdocter.SearchDoctor(spec, city, date);
	}

	@When("user selects the first available doctor")
	public void user_selects_the_first_available_doctor() {
		Pages.Searchdocter.SelectDoctor();
	}

	@When("user selects available slot")
	public void user_selects_available_slot() {
		Pages.Searchdocter.SelectSlot();
	}

	@When("user adds new patient with details")
	public void user_adds_new_patient_with_details(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		String fName = data.get(0).get("firstName");
		String lName = data.get(0).get("lastName");
		String mail = data.get(0).get("email");
		String year = data.get(0).get("year");
		String month = data.get(0).get("month");
		String day = data.get(0).get("day");
		Pages.Searchdocter.AddPatient(fName, lName, mail, year, month, day);
	}

	@Then("booking details should be displayed")
	public void booking_details_should_be_displayed() {
		String url = driver.getCurrentUrl();

		if (url.contains("appointment")) {
			System.out.println("Booking successful");
		} else {
			throw new AssertionError("Booking failed");
		}

	}

}
