package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFamilyPage {

    WebDriver driver;

    public ManageFamilyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------------- LOCATORS ----------------

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

    @FindBy(xpath = "//span[.='Female']")
    private WebElement femaleGender;

    @FindBy(xpath = "//div[@class='AphSelect_select__MnPUj ']")
    private WebElement relationDropdown;

    @FindBy(css = "[data-value='MOTHER']")
    private WebElement motherOption;

    @FindBy(xpath = "//span[.='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//span[.='CONFIRM']")
    private WebElement confirmBtn;

    // ✅ NEW: Generic validation error message
    @FindBy(xpath = "//*[contains(text(),'required') or contains(text(),'invalid') or contains(text(),'enter')]")
    private WebElement validationError;

    // Getter Methods

    public WebElement getProfileIcon() { return profileIcon; }
    public WebElement getManageFamilyMembers() { return manageFamilyMembers; }
    public WebElement getAddNewProfile() { return addNewProfile; }
    public WebElement getFirstName() { return firstName; }
    public WebElement getLastName() { return lastName; }
    public WebElement getDob() { return dob; }
    public WebElement getFemaleGender() { return femaleGender; }
    public WebElement getRelationDropdown() { return relationDropdown; }
    public WebElement getMotherOption() { return motherOption; }
    public WebElement getSaveBtn() { return saveBtn; }
    public WebElement getConfirmBtn() { return confirmBtn; }

    // Business logic

    public void openManageFamilyMembers() {
        profileIcon.click();
        manageFamilyMembers.click();
    }

    public void clickAddNewProfile() {
        addNewProfile.click();
    }

    public void enterFamilyMemberDetails(String fName, String lName, String dateOfBirth) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        dob.sendKeys(dateOfBirth);
    }

    public void selectFemaleAndMother() {
        femaleGender.click();
        relationDropdown.click();
        motherOption.click();
    }

    public void saveFamilyMember() {
        saveBtn.click();
        confirmBtn.click();
    }

    public void addFamilyMember(String fName, String lName, String dobValue) {
        clickAddNewProfile();
        enterFamilyMemberDetails(fName, lName, dobValue);
        selectFemaleAndMother();
        saveFamilyMember();
    }

    //Negative Scenario
    
    // Leave fields empty and click save
    public void clickSaveWithoutEnteringDetails() {
        clickAddNewProfile();
        saveBtn.click();
    }

    // Verify validation error is displayed
    public boolean isValidationErrorDisplayed() {
        try {
            return validationError.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Shadow DOM popup
    public void closePopup(SearchContext shadowRoot) {
        shadowRoot.findElement(By.cssSelector("#close")).click();
    }
}