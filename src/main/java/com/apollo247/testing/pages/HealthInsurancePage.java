package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class HealthInsurancePage {

	public WebDriverWait wait;
	public WebDriver driver;
	public AllUtilityFunctions utility;

	public HealthInsurancePage(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		this.utility = new AllUtilityFunctions();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	}

	// -----------Locator Finding---------------

	@FindBy(css = "[href='https://apollo247insurance.com/health-insurance']")
	private WebElement buyInsuranceButton;

	@FindBy(css = "[type=\"number\"]")
	private WebElement pincodeNumber;

	@FindBy(css = "[alt=\"cross icon\"]")
	private WebElement cancelSelectLocation;

	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitSelectLocation;

	@FindBy(xpath = "//button[normalize-space()='Male']")
	private WebElement maleButton;

	@FindBy(xpath = "//button[normalize-space()='Female']")
	private WebElement femaleButton;

	@FindBy(xpath = "//span[.='Self']")
	private WebElement selectSelfMember;

	@FindBy(xpath = "//span[.='Wife']")
	private WebElement selectWifeMember;

	@FindBy(xpath = "//span[.='Mother']")
	private WebElement selectMotherMember;

	@FindBy(xpath = "//span[.='Father']")
	private WebElement selectFatherMemeber;

	@FindBy(xpath = "//span[.='View Plans']")
	private WebElement viewPlansButton;

	@FindBy(xpath = "//p[.='View Plans']")
	private WebElement viewPlansHeader;

	// ----------Getters ------------
	public WebElement getClickBuyInsurance() {
		return buyInsuranceButton;

	}

	public WebElement getEnterPinCode() {
		return pincodeNumber;
	}

	public WebElement getSubmitButton() {
		return submitSelectLocation;
	}

	public WebElement getViewPlans() {
		return viewPlansButton;
	}

	public WebElement getViewPlansHeader() {
		return viewPlansHeader;
	}

	// ---------Business Logic----------
	public void performEnterPinCode(String pincode) {
		// getClickBuyInsurance().click();
		getEnterPinCode().sendKeys(pincode);
		getSubmitButton().click();
	}

	public void performViewPlans() {
		getViewPlans().click();

	}

	public void selectGender(String gender) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = By.xpath("//button[normalize-space()='" + gender + "']");

		for (int i = 0; i < 3; i++) {
			try {
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator))).click();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying gender click...");
			}
		}
	}

	public void clickViewButton(String buttonName) {

		By locator = By.xpath("//span[normalize-space()='" + buttonName + "']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));

		for (int i = 0; i < 3; i++) {
			try {
				// Wait for DOM stability
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));

				WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));

				// Scroll into view (important for this site)
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

				// Click using JS (bypasses stale + overlay)
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

				return;

			} catch (StaleElementReferenceException e) {
				System.out.println("Retrying due to stale element...");
			}
		}

		throw new RuntimeException("Failed to click View Plans after retries");
	}

	public WebElement viewPlanHeader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='View Plans']")));
	}

	public List<WebElement> viewNumberOfPlans() {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[contains(@class,'plan') or .//button[contains(text(),'Proceed')]]")));

	}

	public void selectMember(String member, String age) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1. Click Member
		By memberLocator = By.xpath("//span[normalize-space()='" + member + "']");
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(memberLocator))).click();

		try {
			WebElement checkbox = driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]"));
			if (checkbox.isSelected()) {
				checkbox.click(); // unselect
			}
		} catch (Exception e) {
			// ignore if not selected
		}

		// 2.Again Click member
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(memberLocator))).click();

		// 3. Wait for dropdown container (VISIBLE, not clickable)
		By dropdownContainer = By.className("MemberTile_popoverIn__JgkxT");
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownContainer));

		// 4. Select Age
		By ageLocator = By.xpath("//li[normalize-space()='" + age + "']");
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(ageLocator))).click();
	}

}
