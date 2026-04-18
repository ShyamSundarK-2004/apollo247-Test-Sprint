package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class ManageFamilyPage {

    WebDriver driver;
    WebDriverWait wait;
    public AllUtilityFunctions utility;

    public ManageFamilyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.utility = new AllUtilityFunctions();
        this.utility.initializeDriver(driver);
    }

    // ----------------------------
    // LOCATORS (STATIC ELEMENTS)
    // ----------------------------

    @FindBy(className = "ProfileNew_profileContainer__mUxKD")
    private WebElement profileIcon;

    @FindBy(xpath = "//span[contains(.,'Manage Family Members')]")
    private WebElement manageFamilyMembers;

    @FindBy(xpath = "//span[contains(.,'Add New Profile')]")
    private WebElement addNewProfile;

    @FindBy(css = "[placeholder='First Name']")
    private WebElement firstName;

    @FindBy(css = "[placeholder='Last name']")
    private WebElement lastName;

    @FindBy(css = "[placeholder='dd/mm/yyyy']")
    private WebElement dob;

    @FindBy(xpath = "//div[contains(@class,'AphSelect_select')]")
    private WebElement relationDropdown;

    @FindBy(xpath = "//span[.='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[.='CONFIRM']")
    private WebElement confirmBtn;

    // ----------------------------
    // NAVIGATION
    // ----------------------------

    public void openManageFamilyMembers() {
        utility.safeClick(driver, profileIcon);
        utility.safeClick(driver, manageFamilyMembers);
    }

    // ----------------------------
    // ADD PROFILE FLOW
    // ----------------------------

    public void clickAddNewProfile() {


        WebElement element = wait.until(
                ExpectedConditions.visibilityOf(addNewProfile)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void enterFamilyMemberDetails(String fName, String lName, String dateOfBirth) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        dob.sendKeys(dateOfBirth);
    }

    public void selectMaleAndBrother() {


        // wait for form to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[placeholder='First Name']")
        ));

        // select Male
        WebElement male = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[contains(text(),'Male')]")
                )
        );
        male.click();

        // open dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'AphSelect_select')]")
                )
        );
        dropdown.click();

        // wait for dropdown options to render
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[data-value='BROTHER']")
        ));

        // re-find fresh element (VERY IMPORTANT)
        WebElement brother = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("[data-value='BROTHER']")
                )
        );

        brother.click();
    }
    public void saveFamilyMember() {
        saveBtn.click();
        confirmBtn.click();
    }

    // ----------------------------
    //  SUCCESS VALIDATION (NEW CLEAN APPROACH)
    // ----------------------------

    public boolean isSuccessToastDisplayed() {


        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[contains(text(),'successfully') or contains(text(),'created') or contains(text(),'added')]")
                    )
            ).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    // ----------------------------
    // FULL FLOW WRAPPER
    // ----------------------------

    public void addFamilyMember(String fName, String lName, String dobValue) {
        enterFamilyMemberDetails(fName, lName, dobValue);
        selectMaleAndBrother();
        saveFamilyMember();
    }

    // ----------------------------
    // NEGATIVE SCENARIO
    // ----------------------------

    public void clickSaveWithoutEnteringDetails() {
        clickAddNewProfile();
        saveBtn.click();
    }

    // ----------------------------
    // SHADOW DOM POPUP
    // ----------------------------

    public void closePopup(SearchContext shadowRoot) {
        shadowRoot.findElement(By.cssSelector("#close")).click();
    }
}