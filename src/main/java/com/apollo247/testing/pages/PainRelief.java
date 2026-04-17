package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.apollo247.testing.utilities.AllUtilityFunctions;

public class PainRelief {

    WebDriver driver;
    AllUtilityFunctions utility;

    public PainRelief(WebDriver driver) {
        this.driver = driver;
        utility = new AllUtilityFunctions();
        utility.initializeDriver(driver);
    }

    @FindBy(xpath="//*[contains(text(),'Filter')]")
    private WebElement filterBtn;

    @FindBy(xpath="(//input[@type='checkbox'])[1]")
    private WebElement firstCheckbox;

    @FindBy(xpath="//*[contains(text(),'Apply')]")
    private WebElement applyBtn;

    @FindBy(xpath="//*[contains(text(),'Sort')]")
    private WebElement sortBtn;

    @FindBy(xpath="//*[contains(text(),'Price Low to High')]")
    private WebElement lowToHigh;

    @FindBy(xpath="(//button[@aria-label='Add'])[1]")
    private WebElement addBtn;

    public void applyFilter() {
        filterBtn.click();
        firstCheckbox.click();
        applyBtn.click();
    }

    public void applySort() {
        sortBtn.click();
        lowToHigh.click();
    }

    public void addProduct() {
        addBtn.click();
    }
}