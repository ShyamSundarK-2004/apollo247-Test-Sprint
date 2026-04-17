package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class CartQuantityUpdate {

    WebDriver driver;
    AllUtilityFunctions utility;

    public CartQuantityUpdate(WebDriver driver) {
        this.driver = driver;
        utility = new AllUtilityFunctions();
        utility.initializeDriver(driver);
    }

    @FindBy(xpath="(//*[contains(text(),'Qty')])[1]")
    private WebElement qtyDropdown;

    @FindBy(xpath="//*[text()='2']")
    private WebElement qtyTwo;

    public void updateQuantity() {
        qtyDropdown.click();
        qtyTwo.click();
    }
}