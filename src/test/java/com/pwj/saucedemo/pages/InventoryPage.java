package com.pwj.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

/**
 * Project Title: SauceDemo Playwright Automation File Name: InventoryPage.java
 * Author: Siddhartha Upadhyay GitHub: https://github.com/Sidpng
 * Creation Date: 29-April-2025 Description: This class models the Inventory
 * page of SauceDemo, providing actions to interact with products, cart, and UI
 * elements.
 */

public class InventoryPage {

	// Locators
	private Locator productTitle;
	private Locator sortDropdown;
	private Locator addToCartButtons;
	private Locator cartIcon;
	@SuppressWarnings("unused")
	private Page page;

	// Constructor
	public InventoryPage(Page page) {
		this.page = page;
		this.productTitle = page.locator(".title");
		this.sortDropdown = page.locator("[data-test='product_sort_container']");
		this.addToCartButtons = page.locator("button[data-test^='add-to-cart']");
		this.cartIcon = page.locator(".shopping_cart_link");
	}

	/**
	 * Returns the title text from the inventory page.
	 */
	public String getPageTitle() {
		return productTitle.textContent().trim();
	}

	/**
	 * Selects a sort option from the dropdown (e.g., "Price (low to high)").
	 * 
	 * @param visibleText The visible option text to select.
	 */
	public void selectSortOption(String visibleText) {
		sortDropdown.selectOption(new SelectOption().setLabel(visibleText));
	}

	/**
	 * Clicks on the first available "Add to Cart" button.
	 */
	public void addFirstProductToCart() {
		addToCartButtons.first().click();
	}

	/**
	 * Clicks all "Add to Cart" buttons on the page.
	 */
	public void addAllProductsToCart() {
		int total = addToCartButtons.count();
		for (int i = 0; i < total; i++) {
			addToCartButtons.nth(i).click();
		}
	}

	/**
	 * Clicks on the cart icon to view added products.
	 */
	public void goToCart() {
		cartIcon.click();
	}

}
