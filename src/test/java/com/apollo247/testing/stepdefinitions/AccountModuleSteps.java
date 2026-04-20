<<<<<<< HEAD
package com.apollo247.testing.stepdefinitions;

import org.testng.Assert;

import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountModuleSteps {

    @Given("user opens My Account panel")
    public void user_opens_my_account_panel() {
        Pages.dashboardPage.clickProfileIcon();
    }

    @When("user navigates to Manage Family Members")
    public void user_navigates_manage_family() {
        Pages.manageFamilyPage.openManageFamilyMembers();
    }

    // ──────────────────────────────────────────
    // MANAGE FAMILY MEMBERS
    // ──────────────────────────────────────────

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

    @When("user adds family members from excel")
    public void user_adds_family_members_from_excel() {
        Pages.manageFamilyPage.addFamilyMembersFromExcel();
    }

    @Then("family member should be created successfully")
    public void family_member_should_be_created_successfully() {
        System.out.println("All members added successfully");
    }

    // ✅ NEW NEGATIVE STEP
    @Then("validation error message should be displayed")
    public void validation_error_message_should_be_displayed() {
        Assert.assertTrue(
            Pages.manageFamilyPage.isValidationErrorDisplayed(),
            "❌ Validation error not displayed"
        );
        System.out.println(" Validation error displayed successfully");
    }

    // ──────────────────────────────────────────
    // MY APPOINTMENTS
    // ──────────────────────────────────────────

    @When("user clicks My Appointments")
    public void user_clicks_my_appointments() {
        Pages.myappointmentsPage.openMyAppointments();
    }

    @When("user refreshes the page")
    public void user_refreshes_the_page() {
        Pages.myappointmentsPage.refreshPage();
    }

    @Then("Appointments section should be displayed")
    public void appointments_section_should_be_displayed() {
        Assert.assertTrue(Pages.myappointmentsPage.isAppointmentsPageDisplayed()," Appointments page not displayed");
        System.out.println("Appointments visible");
    }

    @Then("Appointments section should still be displayed")
    public void appointments_section_should_still_be_displayed() {
        Assert.assertTrue(Pages.myappointmentsPage.isPageLoadedAfterRefresh()," Appointments page not visible after refresh");
        System.out.println("Appointments Page refreshed!");
    }

    // ──────────────────────────────────────────
    // MY MEMBERSHIPS
    // ──────────────────────────────────────────

    @When("user navigates to My Memberships")
    public void user_navigates_to_my_memberships() {
        Pages.membershipsPage.openMyMemberships();
    }

    @When("user clicks Activate Corporate Membership")
    public void user_clicks_activate_corporate_membership() {
        Pages.membershipsPage.clickActivateCorporateMembership();
    }

    @When("user enters corporate email {string}")
    public void user_enters_corporate_email(String email) {
        Pages.membershipsPage.enterCorporateEmail(email);
    }

    @When("user clicks Get OTP")
    public void user_clicks_get_otp() {
        Pages.membershipsPage.clickGetOtp();
    }

    @Then("corporate benefits error message should be displayed")
    public void corporate_benefits_error_message_should_be_displayed() {
        Assert.assertTrue(Pages.membershipsPage.isCorporateErrorDisplayed()," Corporate error not shown");
        System.out.println(" Corporate error verified: " + Pages.membershipsPage.getCorporateErrorText());
    }

    @Then("user dismisses the error popup")
    public void user_dismisses_the_error_popup() {
        Pages.membershipsPage.clickOkGotIt();
    }

    @When("user clicks BUY NOW")
    public void user_clicks_buy_now() {
        Pages.membershipsPage.clickBuyNow();
    }

    @When("user scrolls to {int} months plan and clicks Join Now")
    public void user_scrolls_to_months_plan_and_clicks_join_now(Integer months) {
        Pages.membershipsPage.scrollToAndClickJoinNow(months);
        System.out.println(" Scrolled to " + months + " months plan and clicked Join Now");
    }

    @Then("the following plan details should be visible on the page")
    public void the_following_plan_details_should_be_visible_on_the_page(
            io.cucumber.datatable.DataTable dataTable) {
        java.util.List<String> rows = dataTable.asList(String.class);
        for (int i = 1; i < rows.size(); i++) {
            Assert.assertTrue(Pages.membershipsPage.isPlanDetailVisible(rows.get(i)),"Expected detail not found: '" + rows.get(i) + "'");
            System.out.println(" Found on page: " + rows.get(i));
        }
    }

    // ──────────────────────────────────────────
    // NOTIFICATIONS
    // ──────────────────────────────────────────

    @When("user clicks on Notification Preferences")
    public void user_clicks_on_notification_preferences() {
        Pages.notificationsPage.openNotificationPreferences();
    }

    @Then("Notification Preferences page should be displayed")
    public void notification_preferences_page_should_be_displayed() {
        Assert.assertTrue(
            Pages.notificationsPage.isNotificationPageDisplayed(),
            " Notification Preferences page not loaded"
        );
        System.out.println("Notification Preferences page loaded successfully");
    }

    @When("user enables Push Notifications")
    public void user_enables_push_notifications() {
        Pages.notificationsPage.enablePushNotifications();
        System.out.println(" Push Notifications toggle clicked");
    }

    @Then("Push Notifications toggle should be active")
    public void push_notifications_toggle_should_be_active() {
        Assert.assertTrue( Pages.notificationsPage.isPushToggleVisible()," Push Notifications toggle not visible");
        System.out.println(" Push Notifications is active");
    }

    @When("user enables SMS Notifications")
    public void user_enables_sms_notifications() {
        Pages.notificationsPage.enableSmsNotifications();
        System.out.println("SMS Notifications toggle clicked");
    }

    @Then("SMS Notifications toggle should be active")
    public void sms_notifications_toggle_should_be_active() {
        Assert.assertTrue(Pages.notificationsPage.isSmsToggleVisible()," SMS Notifications toggle not visible");
        System.out.println(" SMS Notifications is active");
    }

    @When("user enables the following notification types")
    public void user_enables_the_following_notification_types(
            io.cucumber.datatable.DataTable dataTable) {
        java.util.List<String> notifications = dataTable.asList(String.class);
        for (int i = 1; i < notifications.size(); i++) {
            Pages.notificationsPage.enableNotificationType(notifications.get(i).trim());
        }
    }

    @Then("all selected notifications should be enabled")
    public void all_selected_notifications_should_be_enabled() {
        Assert.assertTrue(Pages.notificationsPage.areAllTogglesVisible()," Notification toggles not visible");
        System.out.println("Both Push and SMS Notifications enabled successfully");
    }

    // ──────────────────────────────────────────
    // NEED HELP
    // ──────────────────────────────────────────

    @When("user navigates to Need Help")
    public void user_navigates_to_need_help() {
        Pages.needHelpPage.openNeedHelp();
    }

    @Then("all help categories should be visible")
    public void all_help_categories_should_be_visible() {
        Assert.assertTrue(Pages.needHelpPage.areHelpCategoriesVisible()," Help categories not displayed");
        System.out.println("All help categories visible");
    }

    @When("user clicks on Medicines category")
    public void user_clicks_on_medicines_category() {
        Pages.needHelpPage.clickMedicinesCategory();
    }

    @Then("Medicines help page should be loaded")
    public void medicines_help_page_should_be_loaded() {
        Assert.assertTrue(Pages.needHelpPage.isMedicinesPageLoaded(),"Medicines page not loaded");
        System.out.println("Medicines page loaded successfully");
    }

    // ──────────────────────────────────────────
    // LOGOUT
    // ──────────────────────────────────────────

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application() {
        System.out.println("User is already logged in via Hook");
    }

    @When("user clicks on profile icon")
    public void user_clicks_on_profile_icon() {
        Pages.logoutPage.clickProfileIcon();
    }

    @When("user clicks on logout option")
    public void user_clicks_on_logout_option() {
        Pages.logoutPage.clickLogout();
    }

    @Then("user should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {
        Assert.assertTrue(Pages.logoutPage.isLogoutSuccessful()," Logout failed - Login page not displayed");
        System.out.println(" Logout Successful!");
    }
}
=======
//package com.apollo247.testing.stepdefinitions;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.apollo247.testing.utilities.BaseClass;
//import com.apollo247.testing.utilities.Pages;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class AccountModuleSteps extends BaseClass{
//	private BaseClass b;
//
//    public AccountModuleSteps(BaseClass b) {
//        this.b = b;
//    }
//    
////	@Given("Open the browser")
////	public void open_the_browser() {
////		driver = new ChromeDriver();
////		driver.manage().window().maximize();
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
////	}
////	@Given("user launches the Apollo247 {string}")
////	public void user_launches_the_apollo247(String URL) {
////		driver.get(URL);
////		Pages.loadAllPages(driver);
////	    
////	}
////	@Given("user closes the popup")
////	public void user_closes_the_popup() {
////	    Pages.dashboardPage.closeDomPopup();
////	}
////	@When("user logs in with mobile number {string}")
////	public void user_logs_in_with_mobile_number(String mobile) {
////	    Pages.dashboardPage.login(mobile);
////	}
////	@When("user clicks verify after entering OTP")
////	public void user_clicks_verify_after_entering_otp() {
////		Pages.dashboardPage.enterOtpAndclickVerify();
////	    
////	}
//	@When("user opens My Account panel")
//	public void user_opens_my_account_panel() {
//	    Pages.manageFamilyPage.getProfileIcon().click();
//	}
//	@When("user navigates to Manage Family Members")
//	public void user_navigates_to_manage_family_members() {
//	    Pages.manageFamilyPage.getManageFamilyMembers().click();
//	}
//	@When("user clicks Add New Profile")
//	public void user_clicks_add_new_profile() {
//	    Pages.manageFamilyPage.clickAddNewProfile();
//	}
//	@When("user enters family member details {string} {string} {string}")
//	public void user_enters_family_member_details(String fName, String lName, String Dob) {
//	    Pages.manageFamilyPage.addFamilyMember(fName, lName, Dob);
//	}
//	@When("user selects gender as Male and relation as Brother")
//	public void user_selects_gender_as_male_and_relation_as_brother() {
//	    Pages.manageFamilyPage.selectMaleAndBrother();
//	}
//	@When("user clicks Save")
//	public void user_clicks_save() {
//	    Pages.manageFamilyPage.saveFamilyMember();
//	    
//	}
//	@When("user clicks ok")
//	public void user_clicks_ok() {
//		Pages.manageFamilyPage.getokBtn().click();
//	}
//	@Then("new family member {string} should be displayed")
//	public void new_family_member_should_be_displayed(String fName) {
//
//	    WebDriverWait wait = new WebDriverWait(b.driver, Duration.ofSeconds(10));
//
//	    boolean isPresent = wait.until(
//	        ExpectedConditions.visibilityOfElementLocated(
//	            By.xpath("//*[contains(text(),'" + fName + "')]")
//	        )
//	    ).isDisplayed();
//
//	    Assert.assertTrue(isPresent, "Member not added");
//	}
//	}
//
//
>>>>>>> e0e53877cf1731a16176a9c23f5898a1a35ce501
