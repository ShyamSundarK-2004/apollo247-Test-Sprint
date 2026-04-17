package com.apollo247.testing.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchDoctorPage {
	 WebDriver driver;
	    WebDriverWait wait;

	    public SearchDoctorPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        PageFactory.initElements(driver, this);
	    }

    
    @FindBy(xpath = "//span[@class=\"icon-down-arrow\"]")
    private WebElement Speciality;
    
    @FindBy(xpath = "//input[@placeholder=\"Example: Dermatology\"]")
    private WebElement SpecialistInput;
    
    @FindBy(xpath = "//span[@class=\"QuickBook_dateImage__hbyKS icon-date\"]")
    private WebElement dateIcon;
    
    
    @FindBy(xpath = "//input[@placeholder=\"Search location\"]")
    private WebElement location;
    
    @FindBy(xpath = "//li[@role='option']//span[contains(text(),'Chennai')]")
    private WebElement SelectLocation;
    
    @FindBy(xpath = "//span[text()='Submit']")
    private WebElement submitBtn;
    
    @FindBy(xpath = "(//button[text()='Hospital Visit'])[1]")
    private WebElement HospitalVisit;
    
    @FindBy(xpath="//p[text()='Dr. Amvrin Chatterjee']/../../../..//button[text()='Hospital Visit']")
    private WebElement Docter;
    
    @FindBy(xpath = "//div[@class=\"slots_date__Dy0W_ \"]/../../..//p[text()='20']")
    private WebElement dateSlot;
    
    @FindBy(css = "[class=\"slots_slot__YYaL_ slots_selected__xaSp_\"]")
    private WebElement TimeSlot;
    
    @FindBy(xpath = "//span[text()='Continue']")
    private WebElement continueBtn;

    @FindBy(xpath = "//span[text()='Change']")
    private WebElement change;
    
    @FindBy(xpath = "//span[text()='Add Patient']")
    private WebElement addPatientBtn;
    
    @FindBy(css = "[placeholder=\"First Name\"]")
    private WebElement firstName;
    
    @FindBy(css = "[placeholder=\"Last name\"]")
    private WebElement lastName;
    
    @FindBy(xpath = "//input[@placeholder='DD / MM / YYYY']")
    private WebElement dob;
    
    @FindBy(xpath = "//button[text()='Select relation']")
    private WebElement relationDropdown;
    
    @FindBy(xpath = "//button[text()='Male']")
    private WebElement maleButton;
    
    @FindBy(css = "[placeholder=\"Enter Email\"]")
    private WebElement email;
    
    @FindBy(css = "[type=\"checkbox\"]")
    private WebElement Checkbox;
    
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement Save;
	public WebElement getSpeciality() {
		return Speciality;
	}


	public WebElement getSpecialistInput() {
		return SpecialistInput;
	}


	public WebElement getDateIcon() {
		return dateIcon;
	}



	public WebElement getLocation() {
		return location;
	}


	public WebElement getSelectLocation() {
		return SelectLocation;
	}



	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getHospitalVisit() {
		return HospitalVisit;
	}



	public WebElement getDocter() {
		return Docter;
	}


	public WebElement getDateSlot() {
		return dateSlot;
	}



	public WebElement getTimeSlot() {
		return TimeSlot;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}



	public WebElement getChange() {
		return change;
	}


	public WebElement getAddPatientBtn() {
		return addPatientBtn;
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


	public WebElement getRelationDropdown() {
		return relationDropdown;
	}

	public WebElement getMaleButton() {
		return maleButton;
	}


	public WebElement getEmail() {
		return email;
	}



	public WebElement getCheckbox() {
		return Checkbox;
	}


	public WebElement getSave() {
		return Save;
	}
	public void SearchDoctor(String SpecialityName, String LocationName,String date) {
        wait.until(ExpectedConditions.elementToBeClickable(Speciality)).click();
        SpecialistInput.sendKeys(SpecialityName);
        wait.until(ExpectedConditions.elementToBeClickable(
        	    By.xpath("//span[text()='" + SpecialityName + "']")
        	)).click();
        dateIcon.click();
        driver.findElement(By.xpath(
                "//button[contains(@class,'react-calendar__tile')]/abbr[text()='" + date + "']"
            )).click();

        location.click();
        location.clear();
        location.sendKeys(LocationName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//li[@role='option']//span[contains(text(),'" + LocationName + "')]")
        )).click();
        submitBtn.click();
    }

    public void SelectDoctor() {
        wait.until(ExpectedConditions.elementToBeClickable(HospitalVisit)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Docter)).click();
    }
   

    public void SelectSlot() {
        wait.until(ExpectedConditions.elementToBeClickable(dateSlot)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TimeSlot)).click();
        continueBtn.click();
    }

    public void AddPatient(String fName, String lName, String mail,String year, String month, String day) {
        change.click();
        addPatientBtn.click();

        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        selectDOB(year, month, day);

        relationDropdown.sendKeys(Keys.DOWN, Keys.DOWN, Keys.ENTER);
        maleButton.click();

        email.sendKeys(mail);
        Checkbox.click();
        Save.click();
    }
    public void selectDOB(String year, String month, String day) {

        dob.click();

        driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label')]")).click();
        driver.findElement(By.xpath("//span[contains(@class,'react-calendar__navigation__label')]")).click();

        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElement(By.xpath("//button[text()='" + month + "']")).click();
        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
    }
}
