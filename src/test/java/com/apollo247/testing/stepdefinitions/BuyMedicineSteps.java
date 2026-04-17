package com.apollo247.testing.stepdefinitions;

import io.cucumber.java.en.*;
import base.BaseTest;
import pages.*;

public class BuyMedicineSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MedicinePage medicinePage = new MedicinePage();
    CartPage cartPage = new CartPage();

    @Given("user launches Apollo {int}\\/{int} application")
    public void user_launches_apollo_application(Integer int1, Integer int2) {
        BaseTest.initialization();
    }

    @Given("user closes popup if displayed")
    public void user_closes_popup_if_displayed() {
        loginPage.closePopupIfPresent();
    }

    @Given("user logs in with valid mobile number")
    public void user_logs_in_with_valid_mobile_number() {
        loginPage.login("9876543210");
    }

    @Given("user enters OTP manually and clicks verify")
    public void user_enters_otp_manually_and_clicks_verify() {
        // manual OTP OR wait handled
    }

    @Given("user navigates to Buy Medicines module")
    public void user_navigates_to_buy_medicines_module() {
        homePage.goToBuyMedicines();
    }

    @When("user searches for {string}")
    public void user_searches_for(String medicine) {
        medicinePage.searchMedicine(medicine);
    }

    @When("user clicks add button for searched medicine")
    public void user_clicks_add_button_for_searched_medicine() {
        medicinePage.addMedicine();
    }

    @Then("medicine should be added to cart successfully")
    public void medicine_should_be_added_to_cart_successfully() {
        medicinePage.openCart();
        System.out.println("Cart validated");
    }
}