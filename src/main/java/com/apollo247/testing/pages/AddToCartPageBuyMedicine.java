package com.apollo247.testing.pages;

public class AddToCartPageBuyMedicine {

  package com.apollo247.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddToCartPage extends GeneralBP {

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') or contains(text(),'ADD TO CART')]")
    private WebElement addToCartButton;

    @FindBy(css = "span[class*='cartNofify'], span[class*='cartNotify']")
    private WebElement cartCountBadge;

    @FindBy(xpath = "//a[@aria-label='Cart Icon']")
    private WebElement cartIcon;

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        scrollIntoView(addToCartButton);
        safeClick(addToCartButton);
        sleep(2000);
    }

    public String getCartCount() {
        wait.until(ExpectedConditions.visibilityOf(cartCountBadge));
        return cartCountBadge.getText().trim();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        safeClick(cartIcon);
        sleep(3000);
    }
}


}
