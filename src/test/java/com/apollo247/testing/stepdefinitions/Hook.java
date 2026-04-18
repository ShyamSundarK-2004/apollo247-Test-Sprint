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

	// dependency Injection
	public Hook(BaseClass b) {
		this.b = b;
	}

	@Before
	public void setup() throws IOException {
		// reading from property file
		String url = getPropertyKeyValue("url");
		String browser = getPropertyKeyValue("browser");
		// browser setup and launching

		if (browser.equals("chrome")) {
			b.driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			b.driver = new EdgeDriver();
		}

		// assigning driver for utility methods
		initializeDriver(b.driver);

		// launching browser in maximize window
		configMaximizeBrowser();

		// adding a implicit wait for the page to load
		waitForElements(50);

		// navigate to url
		enterURL(url);

		// initialize all the pages with driver using page factory
		Pages.loadAllPages(b.driver);

		// closing the shadow dom popup
		Pages.dashboardPage.closeDomPopup();

		// logging in with mobile number
		Pages.dashboardPage.login(getPropertyKeyValue("phoneNo"));

		// enter otp and verify otp
		Pages.dashboardPage.enterOtpAndclickVerify();

	}

	@After
	public void teadDown() {
		quitBroswerWindow();
	}
}