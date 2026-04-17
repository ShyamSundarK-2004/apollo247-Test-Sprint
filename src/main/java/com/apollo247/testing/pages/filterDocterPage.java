package com.apollo247.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class filterDocterPage{
	@FindBy(linkText = "General Physician/ Internal Medicine")
	private WebElement generalPhysician;

	@FindBy(css = "[type=\"button\"]")
	private WebElement relevanceDropdown;

	@FindBy(xpath = "//span[text()='Price - low to high']")
	private WebElement lowToHigh;

	@FindBy(xpath = "//span[text()='6-10']")
	private WebElement experience;

	@FindBy(xpath = "//span[text()='English']")
	private WebElement language;

}
