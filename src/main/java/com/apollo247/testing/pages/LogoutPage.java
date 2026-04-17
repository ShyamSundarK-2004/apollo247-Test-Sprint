package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // IMPORTANT
    }


    // Login button (visible after logout)
    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    // Getter Methods

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    //Business Methods

    public boolean isLogoutSuccessful(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.isDisplayed();
    }
}