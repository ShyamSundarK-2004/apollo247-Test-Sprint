package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class NotificationsPage {

    WebDriver driver;
    WebDriverWait wait;
    AllUtilityFunctions utilities;

    // Constructor
    public NotificationsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.utilities = new AllUtilityFunctions();
        this.utilities.initializeDriver(driver);
    }

    // ================= LOCATORS =================
    
    @FindBy(className = "ProfileNew_profileContainer__mUxKD")
    private WebElement profileIcon;

    @FindBy(xpath = "//span[contains(.,'Manage Family Members')]")
    private WebElement manageFamilyMembers;

    // Push Notifications toggle
    @FindBy(xpath = "//span[.='Push Notifications']/..//div[@class='SettingsCard_toggleButton__m9vLV']")
    private WebElement pushNotificationsToggle;

    // SMS Notifications toggle
    @FindBy(xpath = "//span[.='SMS Notifications']/..//div[@class='SettingsCard_toggleButton__m9vLV']")
    private WebElement smsNotificationsToggle;
    
    public void openManageFamilyMembers() {
        utilities.safeClick(driver, profileIcon);
        utilities.safeClick(driver, manageFamilyMembers);
    }

    // ================= GETTERS =================

    public WebElement getPushNotificationsToggle() {
        return pushNotificationsToggle;
    }

    public WebElement getSmsNotificationsToggle() {
        return smsNotificationsToggle;
    }

    // ================= BUSINESS LOGIC =================

    // Navigate to Notification Preferences from inside Manage Family section
    public void openNotificationPreferences() {
        WebElement notifLink = utilities.waituntilPresenceOfElementLocated(
            10L, By.xpath("//span[.='Notification Preferences']")
        );
        utilities.safeClick(driver, notifLink);
    }

    // Checks page loaded by looking for key text
    public boolean isNotificationPageDisplayed() {
        String src = driver.getPageSource();
        return src.contains("Push Notifications") ||
               src.contains("SMS Notifications")  ||
               src.contains("Notification Preferences");
    }

    public void enablePushNotifications() {
        utilities.safeClick(driver, pushNotificationsToggle);
    }

    public void enableSmsNotifications() {
        utilities.safeClick(driver, smsNotificationsToggle);
    }

    // Checks push toggle is visible after clicking
    public boolean isPushToggleVisible() {
        return pushNotificationsToggle.isDisplayed();
    }

    // Checks sms toggle is visible after clicking
    public boolean isSmsToggleVisible() {
        return smsNotificationsToggle.isDisplayed();
    }

    // Enables by name — used by DataTable step
    public void enableNotificationType(String type) {
        if (type.equalsIgnoreCase("Push Notifications")) {
            utilities.safeClick(driver, pushNotificationsToggle);
            System.out.println("✅ Enabled: " + type);
        } else if (type.equalsIgnoreCase("SMS Notifications")) {
            utilities.safeClick(driver, smsNotificationsToggle);
            System.out.println("✅ Enabled: " + type);
        }
    }

    // Checks both toggles visible — used by all selected step
    public boolean areAllTogglesVisible() {
        return pushNotificationsToggle.isDisplayed() &&
               smsNotificationsToggle.isDisplayed();
    }

    // Checks toggle ON state via class attribute
    public boolean isPushNotificationEnabled() {
        String toggleClass = pushNotificationsToggle.getAttribute("class");
        return toggleClass != null && (
            toggleClass.contains("active")   ||
            toggleClass.contains("checked")  ||
            toggleClass.contains("enabled")  ||
            toggleClass.contains("toggleOn")
        );
    }

    public boolean isSmsNotificationEnabled() {
        String toggleClass = smsNotificationsToggle.getAttribute("class");
        return toggleClass != null && (
            toggleClass.contains("active")   ||
            toggleClass.contains("checked")  ||
            toggleClass.contains("enabled")  ||
            toggleClass.contains("toggleOn")
        );
    }
}