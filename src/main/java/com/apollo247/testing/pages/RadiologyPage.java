package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.apollo247.testing.utilities.WebdriverUtility;
import com.apollo247.testing.utilities.JavaScriptUtilities;

public class RadiologyPage {

	WebdriverUtility utilities = new WebdriverUtility();
	JavaScriptUtilities jsUtil;
	WebDriver driver;

	public RadiologyPage(WebDriver driver) {
		this.driver = driver;
		utilities.initializeDriver(driver);
		jsUtil = new JavaScriptUtilities(driver);
	}

	// ====== Locators ======

	// select city input field
	@FindBy(xpath = "//div[text() = 'Choose City']")
	private WebElement chooseCityField;

	// select hospital or clinic field
	@FindBy(xpath = "//div[contains(text(), 'Hospital')]")
	private WebElement selectHospitalField;

	// select date field
	@FindBy(xpath = "//button[contains(@class,'datePickerBtn')]")
	private WebElement pickPreferedDate;

	// select test name
	@FindBy(xpath = "//div[text() = 'Choose Tests']")
	private WebElement selectTestName;

	// add test details field
	@FindBy(css = "[placeholder='Add Tests Details']")
	private WebElement addtestDetailsField;

	// upload prescription file field
	@FindBy(xpath = "//input[@type = 'file']")
	private WebElement uploadPrescriptionField;

	// popup dialog box
	@FindBy(xpath = "//div[contains(@class,'AphDialog_paper')]")
	private WebElement bookRadiologyPopup;

	// popup close button
	@FindBy(css = "[alt='close']")
	private WebElement closePopupBtn;

	// ====== Getters ======

	public WebElement getChooseCityField() {
		return chooseCityField;
	}

	public WebElement getSelectHospitalField() {
		return selectHospitalField;
	}

	public WebElement getPickPreferedDate() {
		return pickPreferedDate;
	}

	public WebElement getSelectTestName() {
		return selectTestName;
	}

	public WebElement getAddtestDetailsField() {
		return addtestDetailsField;
	}

	public WebElement getUploadPrescriptionField() {
		return uploadPrescriptionField;
	}

	public WebElement getBookRadiologyPopup() {
		return bookRadiologyPopup;
	}

	public WebElement getClosePopupBtn() {
		return closePopupBtn;
	}

	// ====== Business Logic ======

	public void closeRadiologyPopup() {
		try {
			if (getBookRadiologyPopup().isDisplayed()) {
				getClosePopupBtn().click();
			}
		} catch (Exception e) {

		}
	}

	public void chooseCity(String cityName) {
		jsUtil.jsClick(getChooseCityField());
		utilities.waitUntilElementIsVisibility(20L, getChooseCityField());
		getUploadPrescriptionField().click();
		WebElement chooseCity = driver.findElement(By.xpath("//li[text() = '" + cityName + "']"));
		chooseCity.click();
	}

	public void chooseHospital(String hospitalAreaName) {
		getSelectHospitalField().click();
		WebElement selecthospital = driver.findElement(By.xpath("//li[contains(text(),'" + hospitalAreaName + "')]"));
		selecthospital.click();
	}

	public String getCurrentPageUrl() {
		return utilities.fetchApplicationURL();
	}

}
