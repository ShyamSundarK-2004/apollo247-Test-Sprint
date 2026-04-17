package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath =
            "//div[@role='button'][.//*[contains(text(),'Add to Cart') or contains(text(),'ADD TO CART')]]" +
            " | //div[@role='button'][contains(.,'Add to Cart')]" +
            " | //button[contains(text(),'ADD TO CART') or contains(text(),'Add to Cart')]")
    private WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) { super(driver); }

    public String getPriceText() {
        List<WebElement> priceEls = driver.findElements(
                By.xpath("//*[contains(text(),'\u20B9')][not(self::script)][not(self::style)]"));
        return priceEls.isEmpty() ? "N/A" : priceEls.get(0).getText().trim();
    }

    public void clickAddToCart() {
        WebElement btn = new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        scrollIntoView(btn);
        safeClick(btn);
        sleep(2500);
    }
}
