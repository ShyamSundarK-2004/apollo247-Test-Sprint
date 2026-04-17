package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFamilyPage {

    WebDriver driver;

    // Constructor
    public ManageFamilyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


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

    // Getter Methods

    public WebElement getProfileIcon() {
        return profileIcon;
    }

    public WebElement getManageFamilyMembers() {
        return manageFamilyMembers;
    }

    public WebElement getAddNewProfile() {
        return addNewProfile;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getDob() {
        return dob;
    }

    public WebElement getFemaleGender() {
        return femaleGender;
    }

    public WebElement getRelationDropdown() {
        return relationDropdown;
    }

    public WebElement getMotherOption() {
        return motherOption;
    }

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    public WebElement getConfirmBtn() {
        return confirmBtn;
    }

    // Business Methods

    // Navigate to Manage Family Members
    public void openManageFamilyMembers() {
        profileIcon.click();
        manageFamilyMembers.click();
    }

    // Click Add New Profile
    public void clickAddNewProfile() {
        addNewProfile.click();
    }

    // Enter details
    public void enterFamilyMemberDetails(String fName, String lName, String dateOfBirth) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        dob.sendKeys(dateOfBirth);
    }

    // Select gender + relation
    public void selectFemaleAndMother() {
        femaleGender.click();
        relationDropdown.click();
        motherOption.click();
    }

    // Save member
    public void saveFamilyMember() {
        saveBtn.click();
        confirmBtn.click();
    }

    // Full reusable flow
    public void addFamilyMember(String fName, String lName, String dobValue) {
        clickAddNewProfile();
        enterFamilyMemberDetails(fName, lName, dobValue);
        selectFemaleAndMother();
        saveFamilyMember();
    }

    // Shadow DOM popup handling (kept same)
    public void closePopup(SearchContext shadowRoot) {
        shadowRoot.findElement(By.cssSelector("#close")).click();
    }
}