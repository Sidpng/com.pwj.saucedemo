// Project Title     : SauceDemo Automation Framework using Playwright with Java
// File Name         : CheckoutPage.java
// Author Name       : Siddhartha Upadhyay
// GitHub Link       : https://github.com/YourUsername/saucedemo-playwright-java
// Creation Date     : 01-May-2025
// Description       : Page Object Model class for Checkout Step One Page – captures user info and proceeds to overview.

package com.pwj.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {

	// Locators for form fields and buttons
	private Locator firstNameInput;
	private Locator lastNameInput;
	private Locator postalCodeInput;
	private Locator continueButton;
	private Locator cancelButton;
	private Locator checkoutButton;

	// Constructor
	public CheckoutPage(Page page) {
		this.firstNameInput = page.locator("#first-name");
		this.lastNameInput = page.locator("#last-name");
		this.postalCodeInput = page.locator("#postal-code");
		this.continueButton = page.locator("#continue");
		this.cancelButton = page.locator("#cancel");
		this.checkoutButton = page.locator("#checkout");
	}

	/**
	 * Fill in all the required user information on the checkout page
	 * 
	 * @param first  First name of the user
	 * @param last   Last name of the user
	 * @param postal Zip or postal code
	 */
	public void enterCheckoutInformation(String first, String last, String postal) {
		firstNameInput.fill(first);
		lastNameInput.fill(last);
		postalCodeInput.fill(postal);
	}

	/**
	 * Clicks the Continue button to proceed to checkout overview
	 */
	public void clickContinue() {
		continueButton.click();
	}

	/**
	 * Clicks the Cancel button to return to the cart page
	 */
	public void clickCancel() {
		cancelButton.click();
	}

	public void clickCheckout() {
		checkoutButton.click();

	}
}
