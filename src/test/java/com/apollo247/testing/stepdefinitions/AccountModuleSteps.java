package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.pages.MyAppointmentsPage;
import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountModuleSteps extends BaseClass {

    private BaseClass b;

    public AccountModuleSteps(BaseClass b) {
        this.b = b;
    }

    // ----------------------------
    // NAVIGATION
    // ----------------------------

    @Given("user opens My Account panel")
    public void user_opens_my_account_panel() {

        // Open profile icon → Manage Family Members
        Pages.manageFamilyPage.openManageFamilyMembers();
    }

    // ----------------------------
    // ADD FAMILY MEMBER FLOW
    // ----------------------------

    @When("user clicks Add New Profile")
    public void user_clicks_add_new_profile() {

        Pages.manageFamilyPage.clickAddNewProfile();
    }

    @When("user enters family member details {string} {string} {string}")
    public void user_enters_family_member_details(String fName, String lName, String dob) {

        Pages.manageFamilyPage.addFamilyMember(fName, lName, dob);
    }

    @When("user selects gender as Male and relation as Brother")
    public void user_selects_gender_as_male_and_relation_as_brother() {

        Pages.manageFamilyPage.selectMaleAndBrother();
    }

    @When("user clicks Save")
    public void user_clicks_save() {

        Pages.manageFamilyPage.saveFamilyMember();
    }

    // ----------------------------
    // VALIDATION (UPDATED)
    // ----------------------------

    @Then("family member should be created successfully")
    public void family_member_should_be_created_successfully() {

        boolean status = Pages.manageFamilyPage.isSuccessToastDisplayed();

        Assert.assertTrue(status, "❌ Family member creation success message not displayed");
    }
    
    //My Appointments
    @When("user clicks My Appointments")
    public void user_clicks_my_appointments() {
    	Pages.myappointmentsPage.openMyAppointments();

    }
    @When("user refreshes the page")
    public void user_refreshes_the_page() {
        Pages.myappointmentsPage.refreshPage();
    }
    @Then("Appointments section should still be displayed")
    public void appointments_section_should_still_be_displayed() {
    	 boolean status = Pages.myappointmentsPage.isAppointmentsPageDisplayed();
    	 Assert.assertTrue(status, "Appointments page not displayed");
    }
    
    @Then("Appointments section should be displayed")
    public void appointments_section_should_be_displayed() {
    	boolean status = Pages.myappointmentsPage.isPageLoadedAfterRefresh();
        Assert.assertTrue(status, "❌ Appointments page not visible after refresh");
    }
}