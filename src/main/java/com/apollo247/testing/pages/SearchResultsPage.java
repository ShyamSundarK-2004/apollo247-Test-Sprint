package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBy.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends GeneralBP {

    @FindBy(css = "div[class*='ProductCard'],div[class*='productCard'],div[class*='searchCard']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@role='button'][.//span[contains(text(),'Add to Cart') or contains(text(),'ADD TO CART')]]")
    private List<WebElement> addToCartButtonsOnGrid;

    @FindBy(css = "div[class*='ProductCard'] a[aria-label]")
    private List<WebElement> productLinks;

    public SearchResultsPage(WebDriver driver) { super(driver); }

    public int getProductCount() { return productCards.size(); }

    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    /** Add first result directly from grid if tile exposes an Add button; else open first product. */
    public String addFirstResultToCart() {
        // Try grid Add to Cart first
        if (!addToCartButtonsOnGrid.isEmpty()) {
            WebElement btn = addToCartButtonsOnGrid.get(0);
            scrollIntoView(btn);
            safeClick(btn);
            sleep(2500);
            dismissLocationModal();
            return "first grid result";
        }
        // Fallback: open product -> add on details page
        WebElement firstLink = productLinks.get(0);
        String prod = firstLink.getAttribute("aria-label");
        scrollIntoView(firstLink);
        safeClick(firstLink);
        sleep(3500);
        dismissLocationModal();
        new ProductDetailsPage(driver).clickAddToCart();
        return prod;
    }

    private void dismissLocationModal() {
        try {
            List<WebElement> skipBtns = driver.findElements(By.xpath(
                    "//button[contains(text(),'Skip') or contains(text(),'Later') or contains(text(),'Cancel')]" +
                    " | //div[@role='button'][contains(.,'Skip') or contains(.,'Later')]"));
            if (!skipBtns.isEmpty()) { skipBtns.get(0).click(); sleep(500); }
        } catch (Exception ignored) {}
    }
}
