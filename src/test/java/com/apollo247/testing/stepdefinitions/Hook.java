package com.apollo247.testing.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.apollo247.testing.utilities.AllUtilityFunctions;
import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllUtilityFunctions {

	private BaseClass b;

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

		// login in the website
		Pages.dashboardPage.login(readerUtil.getPropertyKeyValue("phoneNo"));
		Pages.dashboardPage.enterOtpAndclickVerify();
	}

	@After
	public void teadDown() {
		quitBroswerWindow();
	}
}
