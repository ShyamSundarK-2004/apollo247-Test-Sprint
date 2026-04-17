package com.apollo247.testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MedicinePage {

    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

    public MedicinePage() {
        PageFactory.initElements(BaseTest.driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Search medicines']")
    WebElement searchBox;

    @FindBy(xpath = "(//button[contains(text(),'Add')])[1]")
    WebElement addButton;

    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    WebElement viewCart;

    public void searchMedicine(String medicine) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(medicine);
    }

    public void addMedicine() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        viewCart.click();
    }
}