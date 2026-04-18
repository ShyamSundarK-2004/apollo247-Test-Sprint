package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class NeedHelpPage {

    WebDriver driver;
    WebDriverWait wait;
    AllUtilityFunctions utilities;

    // Constructor
    public NeedHelpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.utilities = new AllUtilityFunctions();
        this.utilities.initializeDriver(driver);
    }

    // ===== NAVIGATION LOCATORS =====
    @FindBy(className = "ProfileNew_profileContainer__mUxKD")
    private WebElement profileIcon;

    @FindBy(xpath = "//span[text()='Need Help']")
    private WebElement needHelpOption;

    // ===== PAGE LOCATORS =====
    @FindBy(xpath = "//div[text()='Medicines']")
    private WebElement medicinesCategory;

    // ===== NAVIGATION METHOD =====
    public void openNeedHelp() {

        // Close popup if present
        try {
            WebElement popup = utilities.waituntilPresenceOfElementLocated(10L,
                    By.cssSelector("ct-web-popup-imageonly"));
            SearchContext shadow = popup.getShadowRoot();
            shadow.findElement(By.id("close")).click();
        } catch (Exception e) {}

        // Click profile icon
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();

        // Click Need Help
        utilities.safeClick(driver, needHelpOption);
    }

    // ===== BUSINESS LOGIC =====
    public void clickMedicinesCategory() {
        utilities.safeClick(driver, medicinesCategory);
    }

    public boolean areHelpCategoriesVisible() {
        String pageText = driver.getPageSource();
        return pageText.contains("Medicines") ||
               pageText.contains("Doctor Appointments") ||
               pageText.contains("Lab Tests") ||
               pageText.contains("Unsubscribe") ||
               pageText.contains("OneApollo Membership") ||
               pageText.contains("Circle Membership") ||
               pageText.contains("Account & Health Records") ||
               pageText.contains("Apollo SBI Card Select") ||
               pageText.contains("Insurance Related Query");
    }

 // ✅ NEW - checks URL and page source only, no element lookup needed
    public boolean isMedicinesPageLoaded() {
        wait.until(ExpectedConditions.urlContains("apollopharmacy"));
        return driver.getCurrentUrl().contains("apollopharmacy") ||
               driver.getPageSource().contains("Medicines");
    }
}