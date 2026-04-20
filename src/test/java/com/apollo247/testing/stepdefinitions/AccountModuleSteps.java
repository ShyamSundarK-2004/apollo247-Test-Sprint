package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;
import com.apollo247.testing.utilities.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class AccountModuleSteps {

    // =========================
    // BACKGROUND / COMMON FLOW
    // =========================

    @Given("user opens My Account panel")
    public void user_opens_my_account_panel() {
        Pages.dashboardPage.clickProfileIcon();
        System.out.println("User opened My Account panel");
    }

    // =========================
    // MANAGE FAMILY
    // =========================

    @When("user navigates to Manage Family Members")
    public void user_navigates_manage_family() {
        Pages.manageFamilyPage.openManageFamilyMembers();
        System.out.println("Navigated to Manage Family Members");
    }

    @When("user clicks Add New Profile")
    public void user_clicks_add_new_profile() {
        Pages.manageFamilyPage.clickAddNewProfile();
    }

    @When("user enters family member details {string} {string} {string}")
    public void user_enters_family_member_details(String fName, String lName, String dob) {
        Pages.manageFamilyPage.enterFamilyMemberDetails(fName, lName, dob);
    }

    @When("user selects gender as Male and relation as Brother")
    public void user_selects_gender_relation() {
        Pages.manageFamilyPage.selectMaleAndBrother();
    }

    @When("user clicks Save")
    public void user_clicks_save() {
        Pages.manageFamilyPage.saveFamilyMember();
    }

    @When("user adds family members from excel")
    public void user_adds_family_members_from_excel() {
        Pages.manageFamilyPage.addFamilyMembersFromExcel();
        System.out.println("Family members added from Excel");
    }

    @Then("family member should be created successfully")
    public void family_member_created_successfully() {
        boolean status = Pages.manageFamilyPage.isSuccessToastDisplayed();
        Assert.assertTrue(status, "Family member creation failed");
        System.out.println("Family member created successfully");
    }

    @Then("validation error message should be displayed")
    public void validation_error_message_should_be_displayed() {
        boolean status = Pages.manageFamilyPage.isValidationErrorDisplayed();
        Assert.assertTrue(status, "Validation error not displayed");
        System.out.println("Validation error displayed successfully");
    }

    // =========================
    // MY APPOINTMENTS
    // =========================

    @When("user clicks My Appointments")
    public void user_clicks_my_appointments() {
        Pages.myappointmentsPage.openMyAppointments();
        System.out.println("Opened My Appointments");
    }

    @When("user refreshes the page")
    public void user_refreshes_the_page() {
        Pages.myappointmentsPage.refreshPage();
        System.out.println("Page refreshed");
    }

    @Then("Appointments section should be displayed")
    public void appointments_displayed() {
        boolean status = Pages.myappointmentsPage.isAppointmentsPageDisplayed();
        Assert.assertTrue(status, "Appointments page not displayed");
        System.out.println("Appointments page is displayed");
    }

    @Then("Appointments section should still be displayed")
    public void appointments_still_displayed() {
        boolean status = Pages.myappointmentsPage.isPageLoadedAfterRefresh();
        Assert.assertTrue(status, "Appointments page not visible after refresh");
        System.out.println("Appointments page persists after refresh");
    }

    // =========================
    // MY MEMBERSHIPS
    // =========================

    @When("user navigates to My Memberships")
    public void user_navigates_memberships() {
        Pages.membershipsPage.openMyMemberships();
        System.out.println("Navigated to My Memberships");
    }

    @When("user clicks Activate Corporate Membership")
    public void user_clicks_corporate() {
        Pages.membershipsPage.clickActivateCorporateMembership();
    }

    @When("user enters corporate email {string}")
    public void user_enters_email(String email) {
        Pages.membershipsPage.enterCorporateEmail(email);
    }

    @When("user clicks Get OTP")
    public void user_clicks_otp() {
        Pages.membershipsPage.clickGetOtp();
    }

    @Then("corporate benefits error message should be displayed")
    public void corporate_error_displayed() {
        boolean status = Pages.membershipsPage.isCorporateErrorDisplayed();
        Assert.assertTrue(status, "Corporate error not displayed");
        System.out.println("Corporate error message displayed");
    }

    @Then("user dismisses the error popup")
    public void dismiss_error() {
        Pages.membershipsPage.clickOkGotIt();
        System.out.println("Error popup dismissed");
    }

    @When("user clicks BUY NOW")
    public void click_buy_now() {
        Pages.membershipsPage.clickBuyNow();
    }

    @When("user scrolls to {int} months plan and clicks Join Now")
    public void select_plan(Integer months) {
        Pages.membershipsPage.scrollToAndClickJoinNow(months);
        System.out.println("Selected " + months + " months plan");
    }

    @Then("the following plan details should be visible on the page")
    public void plan_details(DataTable dataTable) {

        List<String> data = dataTable.asList();

        for (int i = 1; i < data.size(); i++) {
            boolean status = Pages.membershipsPage.isPlanDetailVisible(data.get(i));
            Assert.assertTrue(status, "Plan detail not found: " + data.get(i));
            System.out.println("Verified plan detail: " + data.get(i));
        }
    }

    // =========================
    // NOTIFICATIONS
    // =========================

    @When("user clicks on Notification Preferences")
    public void open_notifications() {
        Pages.notificationsPage.openNotificationPreferences();
        System.out.println("Opened Notification Preferences");
    }

    @Then("Notification Preferences page should be displayed")
    public void verify_notifications_page() {
        boolean status = Pages.notificationsPage.isNotificationPageDisplayed();
        Assert.assertTrue(status, "Notification page not displayed");
        System.out.println("Notification Preferences page displayed");
    }

    @When("user enables Push Notifications")
    public void enable_push() {
        Pages.notificationsPage.enablePushNotifications();
    }

    @Then("Push Notifications toggle should be active")
    public void push_active() {
        boolean status = Pages.notificationsPage.isPushToggleVisible();
        Assert.assertTrue(status, "Push toggle not active");
        System.out.println("Push Notifications enabled");
    }

    @When("user enables SMS Notifications")
    public void enable_sms() {
        Pages.notificationsPage.enableSmsNotifications();
    }

    @Then("SMS Notifications toggle should be active")
    public void sms_active() {
        boolean status = Pages.notificationsPage.isSmsToggleVisible();
        Assert.assertTrue(status, "SMS toggle not active");
        System.out.println("SMS Notifications enabled");
    }

    @When("user enables the following notification types")
    public void enable_multiple(DataTable table) {

        List<String> list = table.asList();

        for (int i = 1; i < list.size(); i++) {
            Pages.notificationsPage.enableNotificationType(list.get(i));
        }

        System.out.println("Multiple notifications enabled");
    }

    @Then("all selected notifications should be enabled")
    public void all_enabled() {
        boolean status = Pages.notificationsPage.areAllTogglesVisible();
        Assert.assertTrue(status, "Not all notifications enabled");
        System.out.println("All notifications enabled successfully");
    }

    // =========================
    // NEED HELP
    // =========================

    @When("user navigates to Need Help")
    public void need_help() {
        Pages.needHelpPage.openNeedHelp();
        System.out.println("Opened Need Help");
    }

    @Then("all help categories should be visible")
    public void help_visible() {
        boolean status = Pages.needHelpPage.areHelpCategoriesVisible();
        Assert.assertTrue(status, "Help categories not visible");
        System.out.println("Help categories visible");
    }

    @When("user clicks on Medicines category")
    public void medicines_click() {
        Pages.needHelpPage.clickMedicinesCategory();
    }

    @Then("Medicines help page should be loaded")
    public void medicines_loaded() {
        boolean status = Pages.needHelpPage.isMedicinesPageLoaded();
        Assert.assertTrue(status, "Medicines page not loaded");
        System.out.println("Medicines page loaded");
    }

    // =========================
    // LOGOUT
    // =========================

    @Given("user is logged into the application")
    public void user_logged_in() {
        System.out.println("User already logged in via session");
    }

    @When("user clicks on profile icon")
    public void click_profile() {
        Pages.logoutPage.clickProfileIcon();
    }

    @When("user clicks on logout option")
    public void click_logout() {
        Pages.logoutPage.clickLogout();
    }

    @Then("user should be redirected to login page")
    public void logout_success() {
        boolean status = Pages.logoutPage.isLogoutSuccessful();
        Assert.assertTrue(status, "Logout failed");
        System.out.println("Logout successful, redirected to login page");
    }
}