package com.apollo247.testing.stepdefinitions;

import java.io.*;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.apollo247.testing.utilities.AllUtilityFunctions;
import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllUtilityFunctions {

	private BaseClass b;
	private static final String COOKIES_FILE_PATH = "apollo247_cookies.data";

	public Hook(BaseClass b) {
		this.b = b;
	}

	@Before
	public void setup() throws IOException {
		String url = readerUtil.getPropertyKeyValue("url"); // https://www.apollo247.com/
		String browser = readerUtil.getPropertyKeyValue("browser");

		// 1. Initialize Driver
		if (browser.equalsIgnoreCase("chrome"))
			b.driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("edge"))
			b.driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			b.driver = new FirefoxDriver();

		// initializing driver for utilities
		initializeDriver(b.driver);

		configMaximizeBrowser();

		enterURL(url);

		// loading pages with the driver
		Pages.loadAllPages(b.driver);

		// if popup present close
		try {
			Pages.dashboardPage.closeDomPopup();
		} catch (Exception e) {
			System.out.println("No popup found.");
		}

		// ===================== COOKIE MANAGEMENT =====================
		File cookieFile = new File(COOKIES_FILE_PATH);

		if (cookieFile.exists() && cookieFile.length() > 0) {
			// Load existing cookies
			System.out.println("👉 Loading saved cookies...");
			loadCookies();

			// Refresh to apply cookies
			b.driver.navigate().refresh();

			System.out.println("✅ Cookie session applied successfully!");
			System.out.println("Current URL: " + b.driver.getCurrentUrl());

		} else {
			// First time login - perform manual login
			System.out.println("👉 No cookies found. Performing login...");

			Pages.dashboardPage.login(readerUtil.getPropertyKeyValue("phoneNo"));

			System.out.println("⏳ Waiting for OTP verification...");
			Pages.dashboardPage.enterOtpAndclickVerify();

			// Wait a bit for login to complete
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Save cookies after successful login
			saveCookies();
		}
	}

	/**
	 * Save cookies to file after successful login
	 */
	private void saveCookies() {
		try {
			Set<Cookie> cookies = b.driver.manage().getCookies();

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(COOKIES_FILE_PATH));
			out.writeObject(cookies);
			out.close();

			System.out.println("💾 Cookies saved successfully! (" + cookies.size() + " cookies)");

		} catch (IOException e) {
			System.out.println("⚠️ Error saving cookies: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Load cookies from file
	 */
	@SuppressWarnings("unchecked")
	private void loadCookies() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(COOKIES_FILE_PATH));
			Set<Cookie> cookies = (Set<Cookie>) in.readObject();
			in.close();

			// Clear existing cookies
			b.driver.manage().deleteAllCookies();

			// Add saved cookies
			for (Cookie cookie : cookies) {
				try {
					b.driver.manage().addCookie(cookie);
				} catch (Exception e) {
					System.out.println("⚠️ Skipping cookie: " + cookie.getName() + " (Reason: " + e.getMessage() + ")");
				}
			}

			System.out.println("✅ Loaded " + cookies.size() + " cookies");

		} catch (IOException e) {
			System.out.println("⚠️ Error loading cookies: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("⚠️ Cookie file format error: " + e.getMessage());
		}
	}

	/**
	 * Method to manually clear saved cookies (useful for logout testing)
	 */
	public void clearSavedCookies() {
		File cookieFile = new File(COOKIES_FILE_PATH);
		if (cookieFile.exists()) {
			if (cookieFile.delete()) {
				System.out.println("🗑️ Saved cookies cleared!");
			}
		}
	}

	@After
	public void teadDown() {
		quitBroswerWindow();
	}
}