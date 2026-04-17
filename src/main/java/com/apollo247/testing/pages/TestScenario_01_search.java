package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScenario_01_search {
	WebDriver driver;
    WebDriverWait wait;
    public TestCase_01_search(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//span[@class=\"icon-down-arrow\"]")
    private WebElement dropdown;
    
    @FindBy(xpath = "//input[@placeholder=\"Example: Dermatology\"]")
    private WebElement specialistInput;
    
    @FindBy(xpath = "//span[text()='Andrology']")
    private WebElement AndrologyOption;
    
    @FindBy(xpath = "//span[@class=\"QuickBook_dateImage__hbyKS icon-date\"]")
    private WebElement dateIcon;
    
    @FindBy(xpath = "//button[@class=\"react-calendar__tile react-calendar__month-view__days__day\"]/../..//abbr[text()='20']")
    private WebElement date;
    
    @FindBy(xpath = "//input[@placeholder=\"Search location\"]")
    private WebElement location;
    
    @FindBy(xpath = "//li[@role='option']//span[contains(text(),'Chennai')]")
    private WebElement Option;
    
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitButton;
    
    @FindBy(xpath = "(//button[text()='Hospital Visit'])[1]")
    private WebElement HospitalVisit;
    
    @FindBy(xpath = "//div[@class=\"slots_date__Dy0W_ \"]/../../..//p[text()='20']")
    private WebElement dateSlot;
    
    @FindBy(css = "[class=\"slots_slot__YYaL_ slots_selected__xaSp_\"]")
    private WebElement TimeSlot;
    
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[text()='Change']")
    private WebElement change;
    
    @FindBy(xpath = "//span[text()='Add Patient']")
    private WebElement addPatientButton;
    
    @FindBy(css = "[placeholder=\"First Name\"]")
    private WebElement firstNameField;
    
    @FindBy(css = "[placeholder=\"Last name\"]")
    private WebElement lastNameField;
    
    @FindBy(xpath = "//input[@placeholder='DD / MM / YYYY']")
    private WebElement dobField;
    
    @FindBy(xpath = "//button[text()='Select relation']")
    private WebElement relationDropdown;
    
    @FindBy(xpath = "//button[text()='Male']")
    private WebElement maleButton;
    
    @FindBy(css = "[placeholder=\"Enter Email\"]")
    private WebElement emailField;
    
    @FindBy(css = "[type=\"checkbox\"]")
    private WebElement Checkbox;
    
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement Save;
    
    
    

}
