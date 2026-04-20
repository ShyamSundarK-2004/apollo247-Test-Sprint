package com.apollo247.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PharmacyCartPage extends GeneralBP {

    @FindBy(id = "pharma-cart-container")
    private WebElement cartContainer;

    @FindBy(xpath = "//*[contains(normalize-space(text()),'cart is empty') or contains(normalize-space(text()),'Cart is empty')]")
    private List<WebElement> emptyMessages;

    @FindBy(css = "[class*='MedicineProductCard_medicineName'], [class*='medicineName']")
    private List<WebElement> productNameEls;

    // Qty dropdown header: <p>Qty N</p> (first item)
    @FindBy(xpath = "(//*[contains(@class,'MedicineProductCard_optionHead')])[1]")
    private WebElement firstItemQtyHeader;

    public PharmacyCartPage(WebDriver driver) { super(driver); }

    public boolean isLoaded() {
        try { wait.until(ExpectedConditions.visibilityOf(cartContainer)); return true; }
        catch (Exception ex) { return false; }
    }

    public boolean isEmpty() { return !emptyMessages.isEmpty(); }

    public List<String> getProductNames() {
        java.util.List<String> out = new java.util.ArrayList<>();
        for (WebElement n : productNameEls) {
            String t = n.getText().trim();
            if (!t.isEmpty()) out.add(t);
        }
        return out;
    }

    public String getFirstItemQtyText() {
        try { return firstItemQtyHeader.getText().trim(); }
        catch (Exception ex) { return ""; }
    }

    /** Opens the first item's qty dropdown and picks the value {value}. */
    public void changeFirstItemQtyTo(int value) {
        wait.until(ExpectedConditions.elementToBeClickable(firstItemQtyHeader));
        scrollIntoView(firstItemQtyHeader);
        safeClick(firstItemQtyHeader);
        sleep(1200);
        String xp = "(//div[contains(@class,'MedicineProductCard_optionListRoot')]" +
                "//div[contains(@class,'MedicineProductCard_list')]" +
                "[.//p[contains(@class,'MedicineProductCard_ddQty') and starts-with(normalize-space(.),'" + value + "')]])[1]" +
                " | (//div[contains(@class,'MedicineProductCard_list')][.//p[starts-with(normalize-space(.),'" + value + "')]])[1]";
        WebElement opt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xp)));
        safeClick(opt);
        sleep(2500);
    }

    public String getTotalPriceText() {
        List<WebElement> totals = driver.findElements(By.xpath(
                "//*[contains(@class,'total') or contains(@class,'Total') or contains(@class,'grandTotal')" +
                " or contains(@class,'GrandTotal') or contains(@class,'toPay') or contains(@class,'ToPay')]" +
                "[contains(text(),'\u20B9') or contains(text(),'Rs')]"));
        for (WebElement t : totals) {
            String txt = t.getText().trim();
            if (!txt.isEmpty()) return txt;
        }
        return "";
    }

    /** Removes every item in the cart until empty (cart-cleanup helper). */
    public void emptyCart() {
        int safety = 0;
        while (safety++ < 20) {
            List<WebElement> removeBtns = driver.findElements(By.cssSelector(
                    "[class*='icon-deleteIcon'],[class*='icon-delete']," +
                    "[class*='deleteIcon'],[class*='RemoveIcon']," +
                    "span[class*='icon-remove'],i[class*='icon-delete']"));
            if (removeBtns.isEmpty()) {
                removeBtns = driver.findElements(By.xpath(
                        "//*[normalize-space(text())='Remove' or normalize-space(text())='REMOVE' or normalize-space(text())='Delete']"));
            }
            if (removeBtns.isEmpty()) break;
            try {
                scrollIntoView(removeBtns.get(0));
                js.executeScript("arguments[0].click();", removeBtns.get(0));
            } catch (Exception ignored) {}
            sleep(1200);
            List<WebElement> confirmBtns = driver.findElements(By.xpath(
                    "//button[normalize-space(text())='Remove' or normalize-space(text())='Yes'" +
                    " or normalize-space(text())='REMOVE' or normalize-space(text())='Confirm']" +
                    " | //div[@role='button'][contains(.,'Remove') or contains(.,'Yes') or contains(.,'Confirm')]"));
            if (!confirmBtns.isEmpty()) {
                safeClick(confirmBtns.get(0));
                sleep(1500);
            }
        }
    }
}
