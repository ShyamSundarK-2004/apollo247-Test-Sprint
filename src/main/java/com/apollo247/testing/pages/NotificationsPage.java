package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationsPage {

    WebDriver driver;

    // Constructor
    public NotificationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // IMPORTANT
    }


    @FindBy(xpath = "//span[.='Push Notifications']/..//div[@class='SettingsCard_toggleButton__m9vLV']")
    private WebElement pushNotificationsToggle;

    @FindBy(xpath = "//span[.='SMS Notifications']/..//div[@class='SettingsCard_toggleButton__m9vLV']")
    private WebElement smsNotificationsToggle;

    // Getter Methods

    public WebElement getPushNotificationsToggle() {
        return pushNotificationsToggle;
    }

    public WebElement getSmsNotificationsToggle() {
        return smsNotificationsToggle;
    }

    // Business Logic
    public void enablePushNotifications() {
        pushNotificationsToggle.click();
    }

    public void enableSmsNotifications() {
        smsNotificationsToggle.click();
    }
}