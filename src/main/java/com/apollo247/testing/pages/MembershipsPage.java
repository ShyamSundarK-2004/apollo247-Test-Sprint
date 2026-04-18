package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MembershipsPage {

    WebDriver driver;

    // Constructor
    public MembershipsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // IMPORTANT
    }


    @FindBy(xpath = "//span[.='Activate Corporate Membership']")
    private WebElement activateCorporateMembershipBtn;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//span[.='Get Otp']")
    private WebElement getOtpBtn;

    @FindBy(xpath = "//*[contains(text(),'corporate benefits')]")
    private WebElement corporateBenefitsError;

    @FindBy(xpath = "//span[text()=' Ok, Got it!']")
    private WebElement okGotItBtn;

    @FindBy(xpath = "//span[text()='BUY NOW']")
    private WebElement buyNowBtn;

    @FindBy(xpath = "//*[contains(text(),'12 Months')]")
    private WebElement twelvemonthsPlan;

    @FindBy(xpath = "//button[contains(@class,'CircleLanding_planBtn__f3JcF')]")
    private WebElement joinNowBtn;

    // Getter Methods

    public WebElement getActivateCorporateMembershipBtn() {
        return activateCorporateMembershipBtn;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getGetOtpBtn() {
        return getOtpBtn;
    }

    public WebElement getCorporateBenefitsError() {
        return corporateBenefitsError;
    }

    public WebElement getOkGotItBtn() {
        return okGotItBtn;
    }

    public WebElement getBuyNowBtn() {
        return buyNowBtn;
    }

    public WebElement getTwelvemonthsPlan() {
        return twelvemonthsPlan;
    }

    public WebElement getJoinNowBtn() {
        return joinNowBtn;
    }

    // Business Logic

    public void clickActivateCorporateMembership() {
        activateCorporateMembershipBtn.click();
    }

    public void enterCorporateEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickGetOtp() {
        getOtpBtn.click();
    }

    public String getCorporateBenefitsErrorText(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(corporateBenefitsError));
        return corporateBenefitsError.getText();
    }

    public void clickOkGotIt() {
        okGotItBtn.click();
    }

    public void clickBuyNow() {
        buyNowBtn.click();
    }

    public void scrollToAndClickJoinNow(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[contains(text(),'12 Months')]")));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                twelvemonthsPlan
        );

        joinNowBtn.click();
    }

    public boolean isPlanVisible() {
        String pageText = driver.getPageSource();
        return pageText.contains("12 months") || pageText.contains("12 Months");
    }

    public boolean isPriceVisible() {
        return driver.getPageSource().contains("199");
    }
}