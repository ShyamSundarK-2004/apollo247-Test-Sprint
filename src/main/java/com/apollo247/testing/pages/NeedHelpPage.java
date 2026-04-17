package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeedHelpPage {

    WebDriver driver;

    // Constructor
    public NeedHelpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // IMPORTANT
    }


    @FindBy(xpath = "//div[text()='Medicines']")
    private WebElement medicinesCategory;

    // Getter Methods

    public WebElement getMedicinesCategory() {
        return medicinesCategory;
    }

    // Business Logic

    public void clickMedicinesCategory() {
        medicinesCategory.click();
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

    public boolean isMedicinesPageLoaded(WebDriverWait wait) {
        wait.until(ExpectedConditions.urlContains("apollopharmacy"));
        return driver.getPageSource().contains("Medicines");
    }
}