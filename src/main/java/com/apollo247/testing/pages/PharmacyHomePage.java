package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PharmacyHomePage extends BasePage {

    @FindBy(css = "div[data-placeholder='Search Medicines']")
    private WebElement searchBarTrigger;

    @FindBy(css = "input[placeholder*='Search'],input[placeholder*='search'],input[type='search']")
    private WebElement searchInput;

    @FindBy(css = "a[aria-label='Cart Icon']")
    private WebElement cartIcon;

    public PharmacyHomePage(WebDriver driver) { super(driver); }

    public void openSearch() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div[data-placeholder='Search Medicines']")));
        js.executeScript("arguments[0].click();", searchBarTrigger);
        sleep(800);
    }

    public void searchFor(String keyword) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
        sleep(4000);
        js.executeScript("window.scrollTo(0, 400);");
        sleep(2000);
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        js.executeScript("arguments[0].click();", cartIcon);
        sleep(4000);
    }
}
