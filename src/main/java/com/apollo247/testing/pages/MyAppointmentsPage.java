package com.apollo247.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAppointmentsPage {

    @FindBy(xpath = "//span[contains(.,'My Appointments')]")
    private WebElement myAppointmentsLink;

    // Used for verifying page content after navigation and after refresh
    @FindBy(xpath = "//*[contains(text(),'Appointments') or contains(text(),'No Appointments')]")
    private WebElement appointmentsTextElement;

}  