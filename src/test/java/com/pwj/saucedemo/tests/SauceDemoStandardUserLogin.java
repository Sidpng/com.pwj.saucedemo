package com.pwj.saucedemo.tests;

import com.microsoft.playwright.*;
import com.pwj.saucedemo.base.BaseTest;
import com.pwj.saucedemo.pages.SauceDemoHomePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Project Title: SauceDemo Playwright Automation
 * File Name: SauceDemoStandardUserLogin.java
 * Author: Siddhartha Upadhyay
 * GitHub: https://github.com/your-github-profile
 * Creation Date: 29-April-2025
 * Description: This test class performs a login test using a standard user account on SauceDemo.
 */

public class SauceDemoStandardUserLogin extends BaseTest {

    @Test
    public void testStandardUserLogin() {
    	SauceDemoHomePage landingPage = new SauceDemoHomePage(page);
        landingPage.login("standard_user", "secret_sauce");

        Locator inventoryContainer = page.locator("#inventory_container").first();
        assertTrue(inventoryContainer.isVisible(), "Login failed or inventory page not loaded.");

    }
}
