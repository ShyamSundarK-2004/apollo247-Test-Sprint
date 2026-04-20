package com.apollo247.testing.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class GeneralBP {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public GeneralBP(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // --- Shared helpers ---

    public void closeCleverTapPopup() {
        try {
            WebElement host = driver.findElement(By.cssSelector("ct-web-popup-imageonly"));
            host.getShadowRoot().findElement(By.cssSelector("#close")).click();
            sleep(500);
        } catch (Exception ignored) {}
    }

    public void scrollIntoView(WebElement el) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        sleep(300);
    }

    public void safeClick(WebElement el) {
        try { el.click(); }
        catch (Exception ex) { js.executeScript("arguments[0].click();", el); }
    }

    public void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    public boolean waitVisible(By locator, int seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception ex) { return false; }
    }

    public String getCartBadgeCount() {
        List<WebElement> badge = driver.findElements(
                By.cssSelector("span[class*='HeaderContent_cartNofify']"));
        return badge.isEmpty() ? "0" : badge.get(0).getText().trim();
    }
}
