package com.apollo247.testing.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class HealthInsuranceProductListings {
	
	public WebDriverWait wait;
	public WebDriver driver;
	public AllUtilityFunctions utility;
	
	public HealthInsuranceProductListings(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.driver = driver;
		this.utility = new AllUtilityFunctions();
		this.utility.initializeDriver(driver); // Pass the active driver to utility
	}
	
	//--------------Locator finding-------------
	
	@FindBy(xpath = "//span[.='View Plans']")
	private WebElement viewPlansButton;

	@FindBy(xpath = "//p[.='View Plans']")
	private WebElement viewPlansHeader;
	
	
	
	//----------Getters---------------
	public WebElement getViewPlans() {
		return viewPlansButton;
	}

	public WebElement getViewPlansHeader() {
		return viewPlansHeader;
	}
	
	
	//--------------Business logic--------
	
	public void performViewPlans() {
		getViewPlans().click();

	}
	
	
	
	
	public WebElement viewPlanHeader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='View Plans']")));
	}

	public List<WebElement> viewNumberOfPlans() {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[contains(@class,'plan') or .//button[contains(text(),'Proceed')]]")));

	}
	
	
	public boolean isNoPlansMessageDisplayed() {

		WebElement msg = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//*[contains(text(),'No plans found')]")
		    )
		);

		return msg.isDisplayed();
	}
	
	public boolean isPlansAvailable() {

		WebElement container = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[@class='NewProductListing_listingContainer__HHxUE']")
		    )
		);

		return container.isDisplayed();
	}

}
