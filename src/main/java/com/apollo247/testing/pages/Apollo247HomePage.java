package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class Apollo247HomePage extends BasePage {

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'NavigationNew_navigation')]//a[normalize-space(text())='Buy Medicines']")
    private WebElement buyMedicinesLink;

    public Apollo247HomePage(WebDriver driver) { super(driver); }

    public void openPopupCheck() {
        closeCleverTapPopup();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        safeClick(loginButton);
    }

    public String clickBuyMedicinesAndSwitchTab() {
        Set<String> before = driver.getWindowHandles();
        String parent = driver.getWindowHandle();
        WebElement link;
        try {
            link = wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
        } catch (Exception ex) {
            // Fallback generic
            link = driver.findElement(By.xpath("//a[normalize-space(text())='Buy Medicines']"));
        }
        safeClick(link);
        sleep(3000);
        Set<String> after = driver.getWindowHandles();
        if (after.size() > before.size()) {
            for (String h : after) if (!before.contains(h)) { driver.switchTo().window(h); break; }
        }
        sleep(2000);
        return driver.getCurrentUrl();
    }
}
