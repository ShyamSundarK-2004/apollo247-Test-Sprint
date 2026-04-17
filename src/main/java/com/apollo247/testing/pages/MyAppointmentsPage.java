package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAppointmentsPage {

    WebDriver driver;

    // Constructor
    public MyAppointmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // IMPORTANT
    }


    @FindBy(className = "ProfileNew_profileContainer__mUxKD")
    private WebElement profileIcon;

    @FindBy(xpath = "//span[contains(.,'My Appointments')]")
    private WebElement myAppointments;

    // Getter Methods

    public WebElement getProfileIcon() {
        return profileIcon;
    }

    public WebElement getMyAppointments() {
        return myAppointments;
    }

    // Business Logic

    // Navigate to My Appointments
    public void openMyAppointments() {
        profileIcon.click();
        myAppointments.click();
    }

    // Validate appointments page content
    public boolean isAppointmentsPageDisplayed() {
        String pageText = driver.getPageSource();
        return pageText.contains("Appointments") || pageText.contains("No Appointments");
    }

    // Validate page after refresh
    public boolean isPageLoadedAfterRefresh() {
        return driver.findElement(
                By.xpath("//*[contains(text(),'Appointments') or contains(text(),'No Appointments')]")
        ).isDisplayed();
    }

    // Refresh page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Shadow DOM popup close - reusable
    public void closePopup(SearchContext shadowRoot) {
        shadowRoot.findElement(By.cssSelector("#close")).click();
    }
}