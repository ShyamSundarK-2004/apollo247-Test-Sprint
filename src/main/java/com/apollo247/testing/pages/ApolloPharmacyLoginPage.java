package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ApolloPharmacyLoginPage extends GeneralBP {

    @FindBy(css = "[title='Please enter mobile number']")
    private WebElement mobileInput;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[text()='Verify']")
    private WebElement verifyButton;

    @FindBy(css = ".LoginModal_loginForm__0CKIM")
    private WebElement loginForm;

    public ApolloPharmacyLoginPage(WebDriver driver) { super(driver); }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOf(mobileInput));
        mobileInput.sendKeys(phone);
    }

    public void clickContinue() {
        safeClick(continueButton);
    }

    public void waitAndClickVerify() {
        System.out.println("  --> Type OTP in the browser now. Selenium auto-clicks Verify (40s).");
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(verifyButton)).click();
    }

    public void waitLoggedIn() {
        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(40))
                .until(ExpectedConditions.invisibilityOf(loginForm));
    }
}
