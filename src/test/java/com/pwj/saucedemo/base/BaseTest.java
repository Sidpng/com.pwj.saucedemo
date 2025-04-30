package com.pwj.saucedemo.base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Project Title: SauceDemo Playwright Automation File Name: BaseTest.java
 * Author: Siddhartha Upadhyay GitHub: https://github.com/your-github-profile
 * Creation Date: 29-April-2025 Description: This abstract class provides
 * Playwright browser setup and teardown and should be extended by all test
 * classes.
 */

public abstract class BaseTest {

	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;

	@BeforeMethod
	public void setUp() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
		page.navigate("https://www.saucedemo.com/");
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
