package com.pwj.saucedemo.tests;

import com.microsoft.playwright.*;

public class Demo {

	public static void main(String[] args) {
		// Step 1: Create Playwright and Browser instance
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();

			// Step 2: Navigate to Saucedemo Website. 
			page.navigate("https://www.saucedemo.com/");

			String title = page.title();
			System.out.println("Page Title: " + title);

			if (title.contains("Swag Labs")) {
				System.out.println("✅ Title verification passed.");
			} else {
				System.out.println("❌ Title verification failed.");
			}

			// Step 7: Close browser
			browser.close();
		}
	}
}
