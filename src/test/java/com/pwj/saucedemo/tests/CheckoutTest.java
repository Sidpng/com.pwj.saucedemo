// Project Title     : SauceDemo Automation Framework using Playwright with Java
// File Name         : CheckoutTest.java
// Author Name       : Siddhartha Upadhyay
// GitHub Link       : https://github.com/YourUsername/saucedemo-playwright-java
// Creation Date     : 01-May-2025
// Description       : TestNG test class to validate user information entry and navigation on Checkout Step One page.

package com.pwj.saucedemo.tests;

import com.pwj.saucedemo.base.BaseTest;
import com.pwj.saucedemo.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(description = "Validate user is able to fill info and proceed to overview page")
    public void testValidCheckoutFlow() {
        // Login
        SauceDemoHomePage homePage = new SauceDemoHomePage(page);
        homePage.login("standard_user", "secret_sauce");

        // Add product to cart
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.clickAddToCart("Sauce Labs Backpack");
        inventoryPage.clickCartIcon();

        // Go to checkout
        CheckoutPage cartPage = new CheckoutPage(page);
        cartPage.clickCheckout();

        // Enter user info and continue
        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.enterCheckoutInformation("John", "Doe", "12345");
        checkoutPage.clickContinue();

        // Final URL check
        Assert.assertTrue(page.url().contains("checkout-step-two"), "Should navigate to overview page.");
    }

    @Test(description = "Validate cancel button navigates back to cart page")
    public void testCancelCheckoutFlow() {
        // Login
        SauceDemoHomePage homePage = new SauceDemoHomePage(page);
        homePage.login("standard_user", "secret_sauce");

        // Add product and go to checkout
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.clickAddToCart("Sauce Labs Bike Light");
        inventoryPage.clickCartIcon();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckout();

        // Cancel checkout
        CheckoutPage checkoutPage = new CheckoutPage(page);
        checkoutPage.clickCancel();

        Assert.assertTrue(page.url().contains("cart"), "Cancel should return to cart page.");
    }
}
