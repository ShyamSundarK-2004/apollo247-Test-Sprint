package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageFamilyPage {
	WebDriver driver;
	WebDriverWait wait;

    @FindBy(xpath = "//span[contains(.,'Add New Profile')]")
    private WebElement addNewProfileButton;

    @FindBy(css = "[placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(css = "[placeholder='Last name']")
    private WebElement lastNameInput;

    @FindBy(css = "[placeholder='dd/mm/yyyy']")
    private WebElement dobInput;

    @FindBy(xpath = "//span[.='Female']")
    private WebElement femaleRadioButton;

    @FindBy(xpath = "//div[@class='AphSelect_select__MnPUj ']")
    private WebElement relationDropdown;

    @FindBy(css = "[data-value='MOTHER']")
    private WebElement motherOption;

    @FindBy(xpath = "//span[.='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[.='CONFIRM']")
    private WebElement confirmButton;

}