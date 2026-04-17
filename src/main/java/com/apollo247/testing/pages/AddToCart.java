package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class AddToCart {

    WebDriver driver;
    AllUtilityFunctions utility;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   // Important
        utility = new AllUtilityFunctions();
        utility.initializeDriver(driver);
    }

    @FindBy(xpath = "//span[text()='View Cart']")
    private WebElement viewCart;

    @FindBy(xpath = "//img[contains(@alt,'delete')]")
    private WebElement deleteBtn;

    public void clickCart() {
        utility.clickOnElement(viewCart);
    }

    public void deleteItem() {
        utility.clickOnElement(deleteBtn);
    }
}