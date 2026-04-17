package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.apollo247.testing.utilities.AllUtilityFunctions;

	public class SearchMedicine {

	    WebDriver driver;
	    AllUtilityFunctions utility;

	    public SearchMedicine(WebDriver driver) {
	        this.driver = driver;
	        utility = new AllUtilityFunctions();
	        utility.initializeDriver(driver);
	    }

	    @FindBy(xpath="//div[contains(@class,'SearchPlaceholder')]")
	    private WebElement searchClick;

	    @FindBy(id="searchProduct")
	    private WebElement searchBox;

	    @FindBy(xpath="(//button[@aria-label='Add'])[1]")
	    private WebElement addBtn;

	    public void searchMedicine(String medicine) {
	        searchClick.click();
	        searchBox.sendKeys(medicine);
	    }

	    public void clickAdd() {
	        addBtn.click();
	    }
	}

