/**
 * Project Title: SauceDemo Playwright Automation
 * File Name: SauceDemoStandardUserLogin.java
 * Author: Siddhartha Upadhyay
 * GitHub: https://github.com/your-github-profile
 * Creation Date: 29-April-2025
 * Description: This test class performs a login test using a standard user account on SauceDemo.
 */

package com.pwj.saucedemo.tests;

import com.microsoft.playwright.*;
import com.pwj.saucedemo.pages.SauceDemoHomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class SauceDemoStandardUserLogin {

	private Playwright playwright;
	private Browser browser;
	private BrowserContext context;
	private Page page;

	@BeforeMethod
	public void setUp() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		page.navigate("https://www.saucedemo.com/");
	}

	@Test
	public void testStandardUserLogin() {
		SauceDemoHomePage landingPage = new SauceDemoHomePage(page);
		landingPage.login("standard_user", "secret_sauce");

		// Verify successful login by checking presence of inventory container
		Locator inventoryContainer = page.locator("#inventory_container");
		assertTrue(inventoryContainer.isVisible(), "Login failed or inventory page not loaded.");
	}

	@AfterMethod
	public void tearDown() {
		if (page != null)
			page.close();
		if (context != null)
			context.close();
		if (browser != null)
			browser.close();
		if (playwright != null)
			playwright.close();
	}

}
