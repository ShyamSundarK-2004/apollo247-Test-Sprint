package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/** Shared listing page: Pain Relief, Skin Care, Shop by Brand (Volini), etc. */
public class CategoryPage extends BasePage {

    @FindBy(css = "h1[class*='CategoryContentRoot_productTitle']")
    private WebElement pageTitle;

    @FindBy(css = "div[class*='ProductCard'] a[aria-label]")
    private List<WebElement> productLinks;

    @FindBy(css = "div[class*='ProductCard_productCardGrid']")
    private List<WebElement> productGrid;

    // Volini left-filter pane
    @FindBy(css = "div[class*='CategoryFilterWeb_cfBody']")
    private WebElement filterPane;

    @FindBy(xpath = "//label[contains(@class,'CategoryFilterWeb_accordionHeader')][.//div[@aria-label='Panel Details' and normalize-space(text())='Health Condition']]")
    private WebElement healthConditionAccordion;

    @FindBy(xpath = "//div[contains(@class,'CategoryFilterWeb_labelCustom')][.//label[translate(normalize-space(text()),'INFLAMTO','inflamto')='inflammation']]//label")
    private WebElement inflammationCheckboxLabel;

    public CategoryPage(WebDriver driver) { super(driver); }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText().trim();
    }

    public int getProductCount() { return productGrid.size(); }

    public String selectFirstProduct() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div[class*='ProductCard'] a[aria-label]")));
        WebElement first = productLinks.get(0);
        String name = first.getAttribute("aria-label");
        scrollIntoView(first);
        safeClick(first);
        sleep(3000);
        return name;
    }

    // --- Volini / left-pane filter actions (TC06) ---

    public void expandHealthConditionFilter() {
        wait.until(ExpectedConditions.visibilityOf(filterPane));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//label[contains(@class,'CategoryFilterWeb_accordionHeader')][.//div[@aria-label='Panel Details' and normalize-space(text())='Health Condition']]")));
        scrollIntoView(healthConditionAccordion);
        js.executeScript("arguments[0].click();", healthConditionAccordion);
        sleep(1500);
    }

    public void selectInflammationCheckbox() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[contains(@class,'CategoryFilterWeb_labelCustom')][.//label[translate(normalize-space(text()),'INFLAMTO','inflamto')='inflammation']]//label")));
        scrollIntoView(inflammationCheckboxLabel);
        js.executeScript("arguments[0].click();", inflammationCheckboxLabel);
        sleep(2500);
    }

    // Sort (for TC04 if enabled)
    public boolean applySortPriceLowToHigh() {
        List<WebElement> sortBtns = driver.findElements(
                By.cssSelector("[class*='disabledTag'],[class*='sortTag']"));
        if (sortBtns.isEmpty()) return false;
        scrollIntoView(sortBtns.get(0));
        js.executeScript("arguments[0].click();", sortBtns.get(0));
        sleep(1500);
        List<WebElement> opts = driver.findElements(By.xpath(
                "//*[contains(normalize-space(.),'Low to high') or contains(normalize-space(.),'Low to High')]" +
                "[self::label or self::span or self::div or self::li or self::input]"));
        if (opts.isEmpty()) return false;
        scrollIntoView(opts.get(0));
        js.executeScript("arguments[0].click();", opts.get(0));
        sleep(2500);
        return true;
    }
}
