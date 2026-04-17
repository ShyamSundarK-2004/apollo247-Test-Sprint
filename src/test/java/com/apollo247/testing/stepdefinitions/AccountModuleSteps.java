package com.apollo247.testing.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountModuleSteps extends BaseClass{
	private BaseClass b;

    public AccountModuleSteps(BaseClass b) {
        this.b = b;
    }
    
	@Given("Open the browser")
	public void open_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
	}
	@When("user clicks verify after entering OTP")
	public void user_clicks_verify_after_entering_otp() {
		Pages.dashboardPage.enterOtpAndclickVerify();
	    
	}
	@When("user opens My Account panel")
	public void user_opens_my_account_panel() {
	    Pages.manageFamilyPage.getProfileIcon().click();
	}
	@When("user navigates to Manage Family Members")
	public void user_navigates_to_manage_family_members() {
	    Pages.manageFamilyPage.getManageFamilyMembers().click();
	}
	@When("user clicks Add New Profile")
	public void user_clicks_add_new_profile() {
	    Pages.manageFamilyPage.clickAddNewProfile();
	}
	@When("user enters family member details {string} {string} {string}")
	public void user_enters_family_member_details(String fName, String lName, String Dob) {
	    Pages.manageFamilyPage.addFamilyMember(fName, lName, Dob);
	}
	@When("user selects gender as Male and relation as Brother")
	public void user_selects_gender_as_male_and_relation_as_brother() {
	    Pages.manageFamilyPage.selectMaleAndBrother();
	}
	@When("user clicks Save")
	public void user_clicks_save() {
	    Pages.manageFamilyPage.saveFamilyMember();
	    
	}
	@When("user clicks ok")
	public void user_clicks_ok() {
		Pages.manageFamilyPage.getokBtn().click();
	}
	@Then("new family member {string} should be displayed")
	public void new_family_member_should_be_displayed(String fName) {

	    WebDriverWait wait = new WebDriverWait(b.driver, Duration.ofSeconds(10));

	    boolean isPresent = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(),'" + fName + "')]")
	        )
	    ).isDisplayed();

	    Assert.assertTrue(isPresent, "Member not added");
	}
	}


