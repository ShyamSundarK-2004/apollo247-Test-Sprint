package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class LogoutPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public AllUtilityFunctions utilities;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.utilities = new AllUtilityFunctions();
        this.utilities.initializeDriver(driver);
    }

    // ================= LOCATORS =================

    @FindBy(xpath = "//span[contains(.,'Logout')]")
    private WebElement logoutBtn;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    private By profileIconLocator = By.className("ProfileNew_profileContainer__mUxKD");

    // ================= GETTERS =================

    public WebElement getLogoutBtn() { return logoutBtn; }
    public WebElement getLoginBtn()  { return loginBtn; }

    // ================= BUSINESS LOGIC =================

    public void clickProfileIcon() {
        WebElement profile = wait.until(
            ExpectedConditions.elementToBeClickable(profileIconLocator)
        );
        // JS click — avoids overlay interception on profile icon
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", profile);
    }

    public void clickLogout() {
        // Wait for logout option to be present in dropdown
        WebElement logout = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[contains(.,'Logout')]")
            )
        );
        // JS click — avoids <li class="ProfileNew_logOut__7jANB"> interception
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", logout);
    }

    public boolean isLogoutSuccessful() {
        return wait.until(
            ExpectedConditions.visibilityOf(loginBtn)
        ).isDisplayed();
    }
}