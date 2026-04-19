package com.apollo247.testing.pages;

import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class LabTestPage {

	WebDriver driver;
	AllUtilityFunctions utilities;

	public LabTestPage(WebDriver driver) {
		this.driver = driver;
		this.utilities = new AllUtilityFunctions();
		utilities.initializeDriver(driver);

	}

	// ====== LOCATORS ======

	// labtest search bar
	@FindBy(css = "[placeholder='Search for lab tests']")
	private WebElement searchBar;

	// test names inside each result

	@FindBy(xpath = "//p[contains(@class,'RX')]")
	private List<WebElement> testNames;

	// call back popup
	@FindBy(xpath = " //div[@class='CallbackWidget_popUpOpen__5Zh2n']//child::img[@alt='close']")
	private WebElement popupCloseBtn;

	// search result message
	@FindBy(css = "[class='LabTestsSearch_noResultsFound__vFqRD']")
	private WebElement resultNotFoundMsg;

	@FindBy(css = "[href='/lab-tests/radiology']")
	private WebElement radiologyBookingBtn;

	// ===== GETTERS =====

	public WebElement getSearchBar() {
		return searchBar;
	}

	public List<WebElement> getTestNames() {
		return testNames;
	}

	public WebElement getPopupCloseBtn() {
		return popupCloseBtn;
	}

	public WebElement getResultNotFoundMsg() {
		return resultNotFoundMsg;
	}

	public WebElement getRadiologyBookingBtn() {
		return radiologyBookingBtn;
	}

	// ====== BUSINESS LOGIC ======

	// enter search text
	public void searchTest(String text) {
		getSearchBar().click();
		getSearchBar().sendKeys(text);
		getSearchBar().sendKeys(Keys.ENTER);
	}

	public void closePopupIfPresent() {
		try {
			if (getPopupCloseBtn().isDisplayed()) {
				getPopupCloseBtn().click();
			}
		} catch (Exception e) {
			Reporter.log("No Popup showes");
		}
	}

	public boolean isResultDisplayed() {
		return getTestNames().size() > 0;
	}

	public void clickOnRadiologyBookingBtn() {
		getRadiologyBookingBtn().click();
	}

	public String getCurrentPageUrl() {
		return utilities.fetchApplicationURL();
	}

}
