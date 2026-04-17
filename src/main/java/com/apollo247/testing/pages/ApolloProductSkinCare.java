package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class ApolloProductSkinCare {

    WebDriver driver;
    AllUtilityFunctions utility;

    public ApolloProductSkinCare(WebDriver driver) {
        this.driver = driver;
        utility = new AllUtilityFunctions();
        utility.initializeDriver(driver);
    }

    @FindBy(linkText="Apollo Products")
    private WebElement apolloProducts;

    @FindBy(xpath="//*[contains(text(),'Skin Care')]")
    private WebElement skinCare;

    @FindBy(xpath="(//button[@aria-label='Add'])[1]")
    private WebElement addBtn;

    public void openApolloProducts() {
        apolloProducts.click();
    }

    public void clickSkinCare() {
        skinCare.click();
    }

    public void addProduct() {
        addBtn.click();
    }
}