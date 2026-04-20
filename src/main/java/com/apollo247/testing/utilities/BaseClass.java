package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
<<<<<<< HEAD
=======
	private static ThreadLocal<Pages> pages = new ThreadLocal<Pages>();
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9

	// Set driver
	public void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

<<<<<<< HEAD
=======
	// Set Pages instance
	public void setPages(Pages pagesInstance) {
		pages.set(pagesInstance);
	}

>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
	// Get driver
	public WebDriver getDriver() {
		return driver.get();
	}

<<<<<<< HEAD
	// Remove driver
	public void unload() {
		driver.remove();
	}
=======
	// Get pages instance
	public Pages getPages() {
		return pages.get();
	}

	// Remove driver and pages instance
	public void unload() {
		driver.remove();
		pages.remove();
	}

>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
}