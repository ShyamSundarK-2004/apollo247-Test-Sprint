package com.apollo247.testing.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.apollo247.testing.utilities.AllUtilityFunctions;
import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.HandleCookies;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllUtilityFunctions {

	private BaseClass b;

	// dependency Injection
	public Hook(BaseClass b) {
		this.b = b;
	}

	@Before
	public void setup() throws IOException {

		String url = readerUtil.getPropertyKeyValue("url");
		String browser = readerUtil.getPropertyKeyValue("browser");

		// 🚀 Launch browser
		if (browser.equals("chrome")) {
			b.driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			b.driver = new EdgeDriver();
		}

		initializeDriver(b.driver);
		configMaximizeBrowser();
		waitForElements(80);

		// ✅ MUST open URL before cookies
		enterURL(url);

		// load pages
		Pages.loadAllPages(b.driver);

		// ✅ close popup AFTER login
		Pages.dashboardPage.closeDomPopup();

		HandleCookies cookiesUtil = new HandleCookies();
		String cookieFile = "apolloCookies.data";

		// 1. Load cookies
		boolean cookiesLoaded = cookiesUtil.loadCookies(b.driver, cookieFile);

		System.out.println("🔍 Checking session status...");

		// 2. Validate login PROPERLY
		if (!cookiesLoaded || !Pages.dashboardPage.isUserLoggedIn()) {

			System.out.println("👉 Session not found. Redirecting to Login...");

			Pages.dashboardPage.login(readerUtil.getPropertyKeyValue("phoneNo"));
			Pages.dashboardPage.enterOtpAndclickVerify();

			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// 3. Save cookies ONLY if login success
			if (Pages.dashboardPage.isUserLoggedIn()) {
				cookiesUtil.saveCookies(b.driver, cookieFile);
				System.out.println("✅ Login verified! Cookies captured.");
			} else {
				System.out.println("❌ Login failed. Cookies not saved.");
			}

		} else {
			System.out.println("✅ Session restored via cookies.");
		}

		// ✅ close popup AFTER login
		Pages.dashboardPage.closeDomPopup();
	}

	@After
	public void teadDown() {
		quitBroswerWindow();
	}
}