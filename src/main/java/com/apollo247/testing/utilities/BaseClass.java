package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Set driver
	public void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	// Get driver
	public WebDriver getDriver() {
		return driver.get();
	}

	// Remove driver
	public void unload() {
		driver.remove();
	}
}